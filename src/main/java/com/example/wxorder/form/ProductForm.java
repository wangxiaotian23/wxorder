package com.example.wxorder.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Auther: 李清依
 * @Date: 2019/11/17 09:33
 * @Description:
 */
@Data
public class ProductForm {
    private String productId;
    @NotBlank(message = "商品名称不能为空")
    private String productName;
    @NotNull(message = "单价不能为空")
    private BigDecimal productPrice;
    @NotNull(message = "库存不能为空")
    private Integer productStock;

    /**
     * 描述
     */
    private String productDescription;
    /**
     * 小图
     */
    private String productIcon;
    /**
     * 类目编号
     */
    @NotNull(message = "类目编号不能为空")
    private Integer categoryType;
}
