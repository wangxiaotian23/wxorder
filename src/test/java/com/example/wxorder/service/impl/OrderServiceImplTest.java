package com.example.wxorder.service.impl;

import com.example.wxorder.dto.OrderDTO;
import com.example.wxorder.entity.OrderDetail;
import com.example.wxorder.enums.OrderStatusEnum;
import com.example.wxorder.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: 李清依
 * @Date: 2019/11/15 22:44
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;
    String OPEN_ID="110110";
    String ORDER_ID="1573830010462584270";
    @Test
    public void create() {
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerAddress("吉林大学");
        orderDTO.setBuyerName("李清");
        orderDTO.setBuyerPhone("13576149791");
        orderDTO.setBuyerOpenid(OPEN_ID);
        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123456");
        o1.setProductQuantity(1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("234567");
        o2.setProductQuantity(2);

        orderDetailList.add(o1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单] result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        System.out.println(orderService.findOne(ORDER_ID));
    }

    @Test
    public void findList() {
        PageRequest pageRequest=PageRequest.of(0,2);
        Page<OrderDTO> list=orderService.findList(OPEN_ID,pageRequest);
        System.out.println(list);
    }

    @Test
    public void testFindList() {
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}