package com.example.wxorder.dao;

import com.example.wxorder.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: 李清依
 * @Date: 2019/11/14 10:47
 * @Description:
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster,String> {

}
