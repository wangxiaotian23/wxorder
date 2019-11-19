package com.example.wxorder.service;

import com.example.wxorder.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;

/**
 * @Auther: 李清依
 * @Date: 2019/11/16 21:50
 * @Description:
 */
public interface PayService {
    /**
     * 发起支付
     * @param orderDTO
     * @return
     */
    PayResponse create(OrderDTO orderDTO);

    /**
     * 微信异步通知支付结果
     * @param orderDTO
     * @return
     */
    PayResponse notify(OrderDTO orderDTO);

    /**
     * 微信退款
     * @param orderDTO
     * @return
     */
    PayResponse refund(OrderDTO orderDTO);
}
