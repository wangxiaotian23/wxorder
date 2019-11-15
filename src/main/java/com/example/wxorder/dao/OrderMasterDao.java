package com.example.wxorder.dao;

import com.example.wxorder.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: 李清依
 * @Date: 2019/11/14 10:47
 * @Description:
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster,String> {
    /**
     * 按照买家的openid查询
     * 分页查询订单
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
