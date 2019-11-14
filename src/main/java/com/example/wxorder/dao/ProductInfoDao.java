package com.example.wxorder.dao;

import com.example.wxorder.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: 李清依
 * @Date: 2019/11/14 08:41
 * @Description:
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo,String> {
    //根据商品状态获取商品列表
    List<ProductInfo> findByProductStatus(Integer productStatus);

}
