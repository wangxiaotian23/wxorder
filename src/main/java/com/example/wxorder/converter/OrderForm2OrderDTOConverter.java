package com.example.wxorder.converter;

import com.example.wxorder.dto.OrderDTO;
import com.example.wxorder.form.OrderForm;

/**
 * @Auther: 李清依
 * @Date: 2019/11/17 15:08
 * @Description:
 */
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        //购物车

    }
}
