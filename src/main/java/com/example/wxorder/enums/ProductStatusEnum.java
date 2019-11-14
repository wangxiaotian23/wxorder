package com.example.wxorder.enums;

import lombok.Getter;

/**
 * @Auther: 李清依
 * @Date: 2019/11/14 09:50
 * @Description:
 */
@Getter
public enum ProductStatusEnum {
    UP(0, "在架"),
    DOWN(1, "下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
