package com.pinyougou.manager.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.Brand;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.sellergoods.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

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

    //查询所有品牌
    @GetMapping("/findAll")
    public List<Brand> findAll() {

        return brandService.findAll();
    }

    //分页查询所有品牌
    @GetMapping("findByPage")
    public PageResult findByPage(Brand brand,
                                 @RequestParam("page") Integer page,
                                 @RequestParam("rows") Integer rows) throws Exception{
        if (brand !=null && StringUtils.isNoneBlank(brand.getName())){
            brand.setName(new String(brand.getName().getBytes("ISO8859-1"),"uTF-8"));

        }
          return   brandService.findByPage(brand,page, rows);
    }

    //新建品牌
    @PostMapping("/save")
    public boolean save(@RequestBody Brand brand){
        try{
            brandService.saveBrand(brand);
            return  true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  false;
    }

    //修改品牌
    @PostMapping("/update")
    public boolean update(@RequestBody Brand brand){
        try{
            brandService.updateBrand(brand);
            return  true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  false;
    }

    //删除品牌
    @GetMapping("delete")
    public boolean delete ( Long [] ids){
        try{
            brandService.deleteBrand(ids);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  false;
    }


}
