package com.cskaoyan.mapper;

import com.cskaoyan.domain.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);
 int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectByPage(int offset, Integer rows, Integer searchValue);

    int count(@Param("searchid") Integer searchid);
}