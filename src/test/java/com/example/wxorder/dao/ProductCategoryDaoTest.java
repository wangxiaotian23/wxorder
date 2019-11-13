package com.example.wxorder.dao;

import com.example.wxorder.entity.ProductCategory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 李清依
 * @version 1.0
 * @date 2019/11/13 19:49
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductCategoryDaoTest {
    @Autowired
    private ProductCategoryDao dao;
    @Test
    public void findOneTest() {
        ProductCategory productCategory = (ProductCategory)dao.findById(1).get();
        System.out.println(productCategory);
    }
    @Test
    void findByCategoryTypeIn() {

    }
}