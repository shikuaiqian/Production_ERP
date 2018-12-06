package com.cskaoyan.dao.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Order;
import com.cskaoyan.domain.designScheduleDomain.OrderVo;
import com.cskaoyan.domain.designScheduleDomain.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);
 int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<OrderVo> selectByPage(int offset, Integer rows, String searchValue);

    int count(@Param("searchid") String searchid);


}