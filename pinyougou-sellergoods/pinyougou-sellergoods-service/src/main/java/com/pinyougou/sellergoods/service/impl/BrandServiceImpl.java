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
    public PageResult findByPage(int pageNum, int pageSize) {
        PageInfo<PageResult> pageInfo  = PageHelper
                .startPage(pageNum,pageSize)
                .doSelectPageInfo(new ISelect() {
                    @Override
                    public void doSelect() {
                        brandMapper.selectAll();
                    }
                });

        return new PageResult(pageInfo.getTotal(),pageInfo.getList());
    }
}
