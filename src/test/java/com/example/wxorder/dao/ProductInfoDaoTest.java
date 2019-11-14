package com.example.wxorder.dao;

import com.example.wxorder.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: 李清依
 * @Date: 2019/11/14 08:46
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductInfoDaoTest {
    @Autowired
    private ProductInfoDao dao;
    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("怡宝矿泉水");
        productInfo.setProductPrice(new BigDecimal(2.50));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("纯天然，有点甜");
        productInfo.setProductIcon("http:xxx.com/xx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        ProductInfo result =  dao.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByProductStatusTest() {
        List<ProductInfo> result = dao.findByProductStatus(0);
        Assert.assertNotEquals(0,result.size());
    }
}