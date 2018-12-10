package com.cskaoyan.service.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Task;

import java.util.HashMap;
import java.util.Map;

public interface TaskService {
    void update(Task task);

    void delete(String[] ids);

    void insert(Task task);

    Map<String,Object> selectBySearchValue(Map ret, String page, String rows);

    Map<String,Object> selectByPage(String page, String rows);

    Task getTaskIdById(String taskId);
}
