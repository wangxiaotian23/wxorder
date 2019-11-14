package com.example.wxorder.service.impl;

import com.example.wxorder.dao.ProductCategoryDao;
import com.example.wxorder.entity.ProductCategory;
import com.example.wxorder.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 李清依
 * @Date: 2019/11/13 22:52
 * @Description:
 */
@Service
public class ProductCategoryServiceImpl implements CategoryService {
    @Autowired
    ProductCategoryDao repository;
    @Override
    public ProductCategory findOne(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> types) {
        return repository.findByCategoryTypeIn(types);
    }
}
