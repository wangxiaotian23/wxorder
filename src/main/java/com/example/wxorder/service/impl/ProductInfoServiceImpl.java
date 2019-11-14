package com.example.wxorder.service.impl;

import com.example.wxorder.dao.ProductInfoDao;
import com.example.wxorder.entity.ProductInfo;
import com.example.wxorder.enums.ProductStatusEnum;
import com.example.wxorder.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 李清依
 * @Date: 2019/11/14 09:35
 * @Description:
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfo findById(String id) {
        return productInfoDao.findById(id).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findALL(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }
}
