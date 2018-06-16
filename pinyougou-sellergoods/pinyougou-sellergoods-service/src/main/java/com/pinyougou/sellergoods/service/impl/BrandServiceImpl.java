package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.pojo.Brand;
import com.pinyougou.sellergoods.service.BrandService;

import java.util.List;

@Service
public class BrandServiceImpl  implements BrandService {

    @Override
    public List<Brand> findAll() {
        return null;
    }
}
