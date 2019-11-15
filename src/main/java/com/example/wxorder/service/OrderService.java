package com.example.wxorder.service;

import com.example.wxorder.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Auther: 李清依
 * @Date: 2019/11/15 07:57
 * @Description:
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询订单
     * @param orderId
     * @return
     */
    OrderDTO findOne(String orderId);

    /**
     * 查询订单列表-单个人
     * @param buyerOpenId
     * @param pageable
     * @return
     */
    Page<OrderDTO> findList(String buyerOpenId, Pageable pageable);
    /**
     * 分页查询订单列表
     */
    Page<OrderDTO> findList(Pageable pageable);
    /**
     * 取消订单
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单
     */
    OrderDTO paid(OrderDTO orderDTO);


}
