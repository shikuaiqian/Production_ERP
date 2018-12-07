package com.cskaoyan.service.designSchedule.imp;


import com.cskaoyan.dao.designSchedule.TaskMapper;
import com.cskaoyan.domain.designScheduleDomain.Task;
import com.cskaoyan.service.designSchedule.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceimp implements TaskService {

    @Autowired
    TaskMapper taskMapper;
    @Override
    public Map<String, Object> selectByPage(String page1, String rows1) {
        int page = Integer.parseInt(page1);
        int rows = Integer.parseInt(rows1);
        int i = (page - 1) * rows;
        int offset=i>0?i:0;
        List<Task> tasks = taskMapper.selectByPage(offset, rows,null);
        int count = taskMapper.count(null);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total" ,count);
        map.put("rows",tasks);
        return map;
    }



    @Override
    public void insert(Task task) {
        taskMapper.insertSelective(task);
    }

    @Override
    public Map<String, Object> selectBySearchValue(Map searchValue, String page1, String rows1) {
        int page = Integer.parseInt(page1);
        int rows = Integer.parseInt(rows1);
        int i = (page - 1) * rows;
        int offset=i>0?i:0;
        List<Task> tasks = taskMapper.selectByPage(offset,rows,searchValue);
        int count = taskMapper.count(searchValue);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total" ,count);
        map.put("rows",tasks);
        return map;
    }

    @Override
    public void delete(String[] ids) {
        for (int i = 0; i <ids.length ; i++) {
            taskMapper.deleteByPrimaryKey(ids[i]+"") ;
        }
    }

    @Override
    public void update(Task task) {
        taskMapper.updateByPrimaryKey(task);
    }

}
