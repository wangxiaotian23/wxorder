package com.example.wxorder.service;

import com.example.wxorder.entity.ProductCategory;

import java.util.List;

/**
 * @Auther: 李清依
 * @Date: 2019/11/13 22:49
 * @Description:
 */
public interface CategoryService {
    //查询一条记录
    ProductCategory findOne(Integer categoryId);
    //查询所有记录
    List<ProductCategory> findAll();
    //查询分类列表的分类
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    //添加分类
    ProductCategory save(ProductCategory productCategory);
}
