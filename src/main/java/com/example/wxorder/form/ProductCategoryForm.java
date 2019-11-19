package com.example.wxorder.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Auther: 李清依
 * @Date: 2019/11/17 09:40
 * @Description:
 */
public class ProductCategoryForm {
    private Integer categoryId;
    @NotBlank(message = "类目名字不能为空")
    private String categoryName;
    @NotNull(message = "类目编号不能为空")
    private String categoryType;
}
