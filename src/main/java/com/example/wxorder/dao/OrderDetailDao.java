package com.example.wxorder.dao;

import com.example.wxorder.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: 李清依
 * @Date: 2019/11/14 10:39
 * @Description:
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail,String> {
    /**
     * 通过订单id查询详情
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}
