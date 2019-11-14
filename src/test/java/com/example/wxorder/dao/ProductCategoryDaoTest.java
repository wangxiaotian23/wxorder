package com.example.wxorder.dao;

import com.example.wxorder.entity.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 李清依
 * @version 1.0
 * @date 2019/11/13 19:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryDaoTest {
    @Autowired
    private ProductCategoryDao dao;
    @Test
    public void findOneTest() {
        ProductCategory productCategory = (ProductCategory)dao.findById(1).get();
        System.out.println(productCategory);
    }
    @Test
    @Transactional //不在数据库中添加测试数据
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("女生最爱",5);
        ProductCategory result = dao.save(productCategory);
        Assert.assertNotNull(result);
        //Assert.assertNotEquals(null,result);//与上面效果一样
    }
    @Test
    public void saveTest2(){
        ProductCategory productCategory = dao.findById(1).get();
        productCategory.setCategoryType(3);
        dao.save(productCategory);
    }
    /**
     * 传入类型列表，查询包含列表中类型的所有数据
     */
    @Test
    public void findByCategoryType() {
        List<Integer> types = Arrays.asList(2, 3, 4);
        List<ProductCategory> list = dao.findByCategoryTypeIn(types);
        Assert.assertNotEquals(0, list.size());
    }
}