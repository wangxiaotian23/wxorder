package com.example.wxorder.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: 李清依
 * @Date: 2019/11/14 11:02
 * @Description:
 */
@Data
@NoArgsConstructor
public class ResultVo<T> {
    private int code;
    private String msg;
    private T data;
}
