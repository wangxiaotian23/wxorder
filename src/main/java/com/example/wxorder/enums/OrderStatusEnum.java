package com.example.wxorder.enums;

import lombok.Getter;
import retrofit2.http.GET;

/**
 * @Auther: 李清依
 * @Date: 2019/11/14 08:34
 * @Description:
 */
@Getter
public enum  OrderStatusEnum{
    NEW(0,"已下单"),
    FINISH(1, "已完成"),
    CANCEL(2, "已取消"),;

    private Integer code;
    private String msg;
    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
