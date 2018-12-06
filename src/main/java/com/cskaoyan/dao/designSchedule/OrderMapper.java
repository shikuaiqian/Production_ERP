package com.cskaoyan.dao.designSchedule;

import com.cskaoyan.domain.Order;
import com.cskaoyan.domain.Task;
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

    interface TaskMapper {
        int deleteByPrimaryKey(String taskId);

        int insert(Task record);

        int insertSelective(Task record);

        Task selectByPrimaryKey(String taskId);

        int updateByPrimaryKeySelective(Task record);

        int updateByPrimaryKey(Task record);
    }
}