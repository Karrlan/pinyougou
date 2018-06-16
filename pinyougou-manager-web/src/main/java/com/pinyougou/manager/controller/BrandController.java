package com.pinyougou.manager.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.Brand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    /**
     * 引用服务，
     * 调用服务超时的毫秒数
     */
    @Reference
   private BrandService brandService;

    @GetMapping("/findAll")
    public List<Brand> findAll() {


        return brandService.findAll();

    }

}
