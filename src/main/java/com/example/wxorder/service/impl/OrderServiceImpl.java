package com.example.wxorder.service.impl;

import com.example.wxorder.dto.OrderDTO;
import com.example.wxorder.entity.OrderDetail;
import com.example.wxorder.service.OrderService;
import com.example.wxorder.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Auther: 李清依
 * @Date: 2019/11/15 10:23
 * @Description:
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductInfoService productInfoService;
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        //1.查询商品(数量，价格，库存等)
        for (OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            
        }
        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
