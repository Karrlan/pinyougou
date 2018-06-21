package com.pinyougou.sellergoods.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.pojo.Brand;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.mapper.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BrandServiceImpl  implements BrandService {


    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return  brandMapper.findAll();
    }

    @Override
    public PageResult findByPage(Brand brand,Integer pageNum, Integer pageSize) {
        PageInfo<PageResult> pageInfo  = PageHelper
                .startPage(pageNum,pageSize)
                .doSelectPageInfo(new ISelect() {
                    @Override
                    public void doSelect() {
                        brandMapper.findBySearch(brand);
                    }
                });

        return new PageResult(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public void saveBrand(Brand brand) {
       try{
           brandMapper.insertSelective(brand);
       }catch (Exception ex){
           ex.printStackTrace();
       }
    }

    @Override
    public void updateBrand(Brand brand) {
        try{
            brandMapper.updateByPrimaryKey(brand);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteBrand(Long[] ids) {
       try{
           brandMapper.deleteByID(ids);
       }catch (Exception ex){
           ex.printStackTrace();
       }
    }
}
