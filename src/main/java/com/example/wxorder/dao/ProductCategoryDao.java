package com.example.wxorder.dao;

import com.example.wxorder.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李清依
 * @version 1.0
 * @date 2019/11/13 19:39
 */

public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer>{//后面的是主键类型

    /**
     * 通过categoryType集合 查询出ProductCategory集合
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}