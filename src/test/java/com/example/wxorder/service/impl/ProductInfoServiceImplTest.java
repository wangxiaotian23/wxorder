package com.example.wxorder.service.impl;

import com.example.wxorder.dao.ProductInfoDao;
import com.example.wxorder.entity.ProductInfo;
import com.example.wxorder.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Auther: 李清依
 * @Date: 2019/11/14 09:53
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductInfoServiceImplTest {
    @Autowired
    private ProductInfoService productInfoService;
    @Test
    public void findById() {
        System.out.println(productInfoService.findById("123456"));
    }

    @Test
    public void findUpAll() {
        System.out.println(productInfoService.findUpAll());
    }

    @Test
    public void findALL() {
        PageRequest pageRequest=PageRequest.of(0,3);
        Page<ProductInfo> page=productInfoService.findALL(pageRequest);
    }

    @Test
    public void save() {
        ProductInfo info = new ProductInfo();
        info.setProductId("haha456");
        info.setProductName("皮皮虾");
        info.setProductPrice(new BigDecimal(49));
        info.setProductDescription("皮皮虾我们走");
        info.setProductIcon("http://abc.png");
        info.setProductStatus(0);
        info.setProductStock(99);
        info.setCategoryType(4);
        ProductInfo save = productInfoService.save(info);
        Assert.assertNotNull(save);
    }
}