package com.example.wxorder.service.impl;

import com.example.wxorder.entity.ProductCategory;
import com.example.wxorder.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: 李清依
 * @Date: 2019/11/14 10:13
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;
    @Test
    public void findOne() {
        System.out.println(categoryService.findOne(1));
    }

    @Test
    public void findAll() {
        System.out.println(categoryService.findAll());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("男生最爱",4);
        categoryService.save(productCategory);
        System.out.println(categoryService.findAll());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> types = Arrays.asList(3, 4);
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(types);
        System.out.println(list);
    }
}