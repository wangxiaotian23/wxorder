package com.example.wxorder.controller;

import com.example.wxorder.converter.OrderForm2OrderDTOConverter;
import com.example.wxorder.dto.OrderDTO;
import com.example.wxorder.entity.OrderDetail;
import com.example.wxorder.enums.ResultEnum;
import com.example.wxorder.exception.SellException;
import com.example.wxorder.form.OrderForm;
import com.example.wxorder.service.OrderService;
import com.example.wxorder.utils.ResultVOUtil;
import com.example.wxorder.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 李清依
 * @Date: 2019/11/16 21:43
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/buyer/order")
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;
    //创建订单
    @RequestMapping("/create")
    public ResultVo<Map<String,String>> create(@Valid OrderForm orderForm,
                                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){//表单校验，必须带上@Valid参数
            log.error("[创建订单参数不正确],orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode()
                    ,bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO= OrderForm2OrderDTOConverter.convert(orderForm);

        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("[创建订单] 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult=orderService.create(orderDTO);
        Map<String,String> map=new HashMap<>();
        map.put("orderId",createResult.getOrderId());
        return ResultVOUtil.success(map);

    }
    //订单列表
    @GetMapping("/list")
    public ResultVo<List<OrderDetail>> list(@RequestParam("openid") String openid,
                                            @RequestParam(value = "page",defaultValue = "0")Integer page,
                                            @RequestParam(value = "size",defaultValue = "10")Integer size){
        if(StringUtils.isEmpty(openid)){
            log.error("[查询订单列表] openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest=PageRequest.of(page,size);
        Page<OrderDTO> orderDTOPage=orderService.findList(openid,pageRequest);
        return ResultVOUtil.success(orderDTOPage.getContent());
    }
    //订单详情
    @GetMapping("/detail")
    public ResultVo<OrderDTO> detail(
            @RequestParam("openid") String openid,
            @RequestParam("orderId") String orderId){
        if(StringUtils.isEmpty(openid)||StringUtils.isEmpty(orderId)){
            log.error("[查询订单详情] openid为空或orderId为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO orderDTO =orderService.findOne(orderId);
        return ResultVOUtil.success(orderDTO);
    }
    //取消订单
    @PostMapping("/cancel")
    public ResultVo cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId){
        if(StringUtils.isEmpty(openid)||StringUtils.isEmpty(orderId)){
            log.error("[查询订单详情] openid为空或orderId为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO orderDTO=orderService.findOne(orderId);
        orderService.cancel(orderDTO);
        return ResultVOUtil.success();
    }

}
