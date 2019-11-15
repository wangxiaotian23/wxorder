package com.example.wxorder.service;

import com.example.wxorder.dto.OrderDTO;

/**
 * @Auther: 李清依
 * @Date: 2019/11/15 07:53
 * @Description:
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openId,String orderId);
    //取消订单
    OrderDTO cancelOrder(String openId,String orderId);


}
