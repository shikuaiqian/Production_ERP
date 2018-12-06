package com.cskaoyan.dao.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String ProductId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product>  findall();
    int count(@Param("searchid") Integer searchid);
    List<Product> selectByPage(Integer page, Integer rows, Integer i);
}