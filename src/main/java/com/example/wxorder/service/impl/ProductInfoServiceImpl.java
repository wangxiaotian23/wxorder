package com.example.wxorder.service.impl;

import com.example.wxorder.dao.ProductInfoDao;
import com.example.wxorder.dto.CartDto;
import com.example.wxorder.entity.ProductInfo;
import com.example.wxorder.enums.ProductStatusEnum;
import com.example.wxorder.enums.ResultEnum;
import com.example.wxorder.exception.SellException;
import com.example.wxorder.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    @Override
    public void increaseStock(List<CartDto> cartDTOList) {
        for(CartDto cartDTO:cartDTOList){
            ProductInfo productInfo = productInfoDao.findById(cartDTO.getProductId()).get();
            if(productInfo==null){//商品不存在
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //增加库存
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            productInfoDao.save(productInfo);
        }
    }
    @Transactional
    @Override
    public void decreaseStock(List<CartDto> cartDTOList) {
        for(CartDto cartDTO:cartDTOList){
            ProductInfo productInfo=productInfoDao.findById(cartDTO.getProductId()).get();//数据库实际商品
            if(productInfo==null){//商品不存在
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock()-cartDTO.getProductQuantity();
            if(result<0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoDao.save(productInfo);
        }
    }
}
