package com.example.wxorder.dao;

import com.example.wxorder.entity.OrderMaster;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Auther: 李清依
 * @Date: 2019/11/15 09:48
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderMasterDaoTest {
    private final String OPENID = "110100";
    @Autowired
    private OrderMasterDao orderMasterDao;
    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("2");
        orderMaster.setBuyerName("Jack");
        orderMaster.setBuyerPhone("13114515512");
        orderMaster.setBuyerAddress("黄土高原");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(12.5));
        System.out.println(orderMaster);
        OrderMaster result = orderMasterDao.save(orderMaster);
    }
    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest=PageRequest.of(0,2);
        System.out.println(orderMasterDao.findByBuyerOpenid(OPENID,pageRequest));
    }
}