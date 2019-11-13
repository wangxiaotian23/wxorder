package com.example.wxorder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李清依
 * @version 1.0
 * @date 2019/11/13 19:39
 */
@Repository
public interface ProductCategoryDao extends JpaRepository<ProductCategoryDao,Integer> {
    List<ProductCategoryDao> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
