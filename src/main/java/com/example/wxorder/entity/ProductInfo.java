package com.example.wxorder.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Auther: 李清依
 * @Date: 2019/11/13 22:56
 * @Description:
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    //商品名字
    private String productName;

    //商品价格
    private BigDecimal productPrice;

    //商品库存
    private Integer productStock;

    //商品描述
    private String productDescription;

    //商品状态
    private Integer productStatus;

    //商品图标
    private String productIcon;

    //商品类目编号
    private Integer categoryType;

    public ProductInfo() {
    }
}
