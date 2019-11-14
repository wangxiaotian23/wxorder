package com.example.wxorder.enums;

import lombok.Getter;

/**
 * @Auther: 李清依
 * @Date: 2019/11/14 08:35
 * @Description:
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"支付失败"),
    SUCCESS(1, "支付成功"),
    FAIL(2, "支付失败")
    ;
    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
