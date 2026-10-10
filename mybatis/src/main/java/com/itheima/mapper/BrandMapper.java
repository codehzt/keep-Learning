package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /**
     * 查询所有
     */
    List<Brand> selectAll();

    /**
     * 查看详情:根据Id查询
     */
    Brand selectById(int id);

    //List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

    //List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByCondition(Map map);
    List<Brand> selectByConditionSingle(Brand brand);



}
