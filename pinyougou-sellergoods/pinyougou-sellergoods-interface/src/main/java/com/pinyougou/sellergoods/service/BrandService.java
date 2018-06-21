package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.Brand;
import com.pinyougou.pojo.PageResult;

import java.util.List;

/**
 * 品牌服务接口
 */
public interface BrandService {
    //查询所有品牌
    List <Brand> findAll();

    //分页查询品牌列表
    PageResult findByPage(Brand brand,Integer pageNum, Integer pageSize);


    //新建品牌列表
    void  saveBrand(Brand brand);

    void updateBrand(Brand brand);

    void deleteBrand(Long[] ids);
}
