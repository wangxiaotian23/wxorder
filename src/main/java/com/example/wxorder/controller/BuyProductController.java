package com.example.wxorder.controller;

import com.example.wxorder.entity.ProductCategory;
import com.example.wxorder.entity.ProductInfo;
import com.example.wxorder.service.CategoryService;
import com.example.wxorder.service.ProductInfoService;
import com.example.wxorder.utils.ResultVOUtil;
import com.example.wxorder.vo.ProductInfoVO;
import com.example.wxorder.vo.ProductVO;
import com.example.wxorder.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李清依
 * @version 1.0
 * @date 2019/11/14 16:42
 */
@RestController
@RequestMapping(value = "/buyer/product")
public class BuyProductController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductInfoService productInfoService;
    @GetMapping("/list")
    public ResultVo list(){
        //1.先查询所有上架商品
        List<ProductInfo> productInfoList=productInfoService.findUpAll();

        //2.查询类目
        List<Integer> categoryTypeList=new ArrayList<>();
        for (ProductInfo productInfo:productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //拼装数据,拼装成前端所需的数据格式
        List<ProductVO> productVOList = new ArrayList<>();
        //先遍历类目
        for (ProductCategory productCategory:productCategoryList){
            ProductVO productVO=new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            //遍历商品详情
            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);//Spring中的拷贝工具类，能把一样的属性的属性值拷贝过去
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }

}
