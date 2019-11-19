package com.example.wxorder.controller;

import com.example.wxorder.dto.OrderDTO;
import com.example.wxorder.enums.ResultEnum;
import com.example.wxorder.exception.SellException;
import com.example.wxorder.form.OrderForm;
import com.example.wxorder.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    //创建订单
    @RequestMapping("/create")
    public ResultVo<Map<String,String>> create(@Valid OrderForm orderForm,
                                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){//表单校验，必须带上@Valid参数
            log.error("[创建订单参数不正确],orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode()
                    ,bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO=OrderDTO;


    }
    //订单列表
    //订单详情
    //取消订单

}
