package com.example.wxorder.dto;

import lombok.Data;

/**
 * 购物车
 * @Auther: 李清依
 * @Date: 2019/11/15 10:15
 * @Description:
 */
@Data
public class CartDto {
    //商品id
    private String productId;
    //数量
    private Integer productQuantity;

    public CartDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
