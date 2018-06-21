package com.pinyougou.sellergoods.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.mapper.SpecificationMapper;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.Specification;
import com.pinyougou.pojo.SpecificationOption;
import com.pinyougou.sellergoods.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 规格服务接口实现层
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年12月7日 下午1:58:29
 * @version 1.0
 */
@Service(interfaceName="com.pinyougou.sellergoods.service.SpecificationService")
@Transactional(readOnly=false)
public class SpecificationServiceImpl implements SpecificationService {


	@Autowired
	private SpecificationMapper specificationMapper;
	
	/**
	 * 分页查询规格
	 * @param specification 规格实体
	 * @param page 当前页码
	 * @param rows 每页显示的记录数
	 * @return PageResult
	 */
	public PageResult findByPage(Specification specification,
								 Integer page, Integer rows){
		try{
			PageInfo<Specification> pageInfo = PageHelper.startPage(page,rows)
					.doSelectPageInfo(new ISelect() {
						@Override
						public void doSelect() {
							specificationMapper.findByPage(specification);
						}
					});
			return new PageResult(pageInfo.getTotal(),pageInfo.getList());
		}catch (Exception ex){
			throw new RuntimeException(ex);
		}
	}
	/** 添加规格与规格选项 */
	public void saveSpecification(Specification specification){
		try{
			
		}catch (Exception ex){
			throw new RuntimeException(ex);
		}
	}

	/** 根据规格id查询规格选项 */
	public List<SpecificationOption> findOne(Long id){
		try{
			return null;
		}catch (Exception ex){
			throw new RuntimeException(ex);
		}
	}

    /** 修改规格与规格选项  */
    public void updateSpecification(Specification specification){
        try{
           
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    /** 删除规格与规格选项 */
    public void deleteSpecification(Long[] ids){
        try{
           
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

	/** 查询规格列表(id,name) */
	public List<Map<String,Object>> findSpecByIdAndName(){
		try{
			return null;
		}catch (Exception ex){
			throw new RuntimeException(ex);
		}
	}
}