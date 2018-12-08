package com.cskaoyan.dao.designSchedule;


import com.cskaoyan.domain.designScheduleDomain.Task;
import org.apache.ibatis.annotations.Param;

import java.util.*;

public interface TaskMapper {
    int deleteByPrimaryKey(String taskId);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(String taskId);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    List<Task> selectByPage(int offset, int rows, Map o);

    int count(@Param("param3") Map o);
}