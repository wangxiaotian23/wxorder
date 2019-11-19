package com.example.wxorder.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Auther: 李清依
 * @Date: 2019/11/17 09:37
 * @Description:
 */
@Data
public class OrderForm {
    @NotEmpty(message = "姓名必填")
    private String name;
    @NotEmpty(message = "手机号必填")
    private String phone;
    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家微信openId
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
