package com.cskaoyan.dao.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Product;
import java.util.*;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String ProductId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product>  findall();
    int count( Map searchid);
    List<Product> selectByPage(Integer page, Integer rows, Map i);
}