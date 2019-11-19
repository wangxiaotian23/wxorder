package com.example.wxorder.service.impl;

import com.example.wxorder.dto.OrderDTO;
import com.example.wxorder.service.OrderService;
import com.example.wxorder.service.PayService;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

/**
 * @Auther: 李清依
 * @Date: 2019/11/17 08:27
 * @Description:
 */
public class PayServiceImpl implements PayService {

    private final String ORDER_NAME="微信点餐订单";
    @Autowired
    private OrderService orderService;
    @Autowired
    private BestPayServiceImpl bestPayService;

    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest=new PayRequest();
        return null;
    }

    @Override
    public PayResponse notify(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public PayResponse refund(OrderDTO orderDTO) {
        return null;
    }
}
