package com.example.wxorder.dao;

import com.example.wxorder.entity.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: 李清依
 * @Date: 2019/11/15 10:03
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j

public class OrderDetailDaoTest {
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Test
    public void save(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("2");
        orderDetail.setOrderId("332");
        orderDetail.setProductIcon("11111.jpg");
        orderDetail.setProductId("22");
        orderDetail.setProductPrice(new BigDecimal("7.0"));
        orderDetail.setProductQuantity(2);
        orderDetail.setProductName("小鸡腿");
        orderDetailDao.save(orderDetail);
        Assert.assertNotNull(orderDetail);
    }
    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId("332");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}