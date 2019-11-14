package com.example.wxorder.dto;

import com.example.wxorder.enums.OrderStatusEnum;
import com.example.wxorder.enums.PayStatusEnum;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: 李清依
 * @Date: 2019/11/14 10:46
 * @Description:
 */
@Data
public class OrderDTO {
    /**
     * 订单id
     */
    @Id
    private String orderId;

    private String buyerName;
    /**
     * 买家电话
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家微信openid
     */
    private String buyerOpenid;
    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态、0：新下单  1：完成  2：取消
     */
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();
    /**
     * 支付状态。0：未支付  1：已支付  2：支付失败
     */
    private Integer payStatus= PayStatusEnum.WAIT.getCode();
    /**
     * 创建时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

}
