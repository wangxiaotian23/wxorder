package com.example.wxorder.exception;

import com.example.wxorder.enums.ResultEnum;
import lombok.Data;

/**
 * @author 李清依
 * @version 1.0
 * @date 2019/11/14 14:04
 * 自定义程序异常
 */
@Data
public class SellException extends RuntimeException {
    private Integer code;
    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }
    public SellException(Integer code, String defaultMessage) {
        super(defaultMessage);
        this.code=code;
    }

}
