package com.pinyougou.mapper;


import com.pinyougou.pojo.Specification;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpecificationMapper extends Mapper<Specification>{


    List <Specification> findByPage(@Param("specification") Specification specification);
}