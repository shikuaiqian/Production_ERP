package com.cskaoyan.service.designSchedule.imp;

import com.cskaoyan.dao.designSchedule.WorkMapper;
import com.cskaoyan.domain.designScheduleDomain.Work;
import com.cskaoyan.service.designSchedule.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorkServiceimp implements WorkService{

    @Autowired
    WorkMapper workMapper;
    @Override
    public Map<String, Object> selectByPage(String page1, String rows1) {
        int page = Integer.parseInt(page1);
        int rows = Integer.parseInt(rows1);
        int i = (page - 1) * rows;
        int offset=i>0?i:0;
        List<Work> works = workMapper.selectByPage(offset, rows,null);
        int count = workMapper.count(null);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total" ,count);
        map.put("rows",works);
        return map;
    }

    @Override
    public Map<String, Object> selectBysearchValue(Map searchValue, String page1, String rows1) {
        int page = Integer.parseInt(page1);
        int rows = Integer.parseInt(rows1);
        int i = (page - 1) * rows;
        int offset=i>0?i:0;
        List<Work> works = workMapper.selectByPage(offset,rows,searchValue);
        int count = workMapper.count(searchValue);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total" ,count);
        map.put("rows",works);
        return map;
    }

    @Override
    public void insert(Work work) {
        workMapper.insertSelective(work);
    }

    @Override
    public void delete(String[] ids) {
        for (int i = 0; i <ids.length ; i++) {
            workMapper.deleteByPrimaryKey(ids[i]+"") ;
        }
    }

    @Override
    public void update(Work work) {
        workMapper.updateByPrimaryKey(work);
    }

    @Override
    public Work getWorkIdById(String workId) {
        return workMapper.selectByPrimaryKey(workId);
    }

    @Override
    public List<Work> findAll() {
        return workMapper.findAll();
    }

}
