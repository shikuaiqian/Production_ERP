package com.cskaoyan.service.imp;

import com.cskaoyan.domain.Custom;
import com.cskaoyan.dao.designSchedule.CustomMapper;
import com.cskaoyan.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomServiecimp  implements CustomService{
    @Autowired
    CustomMapper customMapper;
    @Override
    public Map<String, Object> selectByPage(Integer page, Integer rows) {
        int i = (page - 1) * rows;
        int offset=i>0?i:0;
        List<Custom> customs = customMapper.selectByPage(offset, rows,null);
        int count = customMapper.count(null);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total" ,count);
        map.put("rows",customs);
        return map;
    }

    @Override
    public Map<String, Object> selectByIdandPage(Integer searchValue, Integer page, Integer rows) {
        int i = (page - 1) * rows;
        int offset=i>0?i:0;
        List<Custom> customs = customMapper.selectByPage(offset,rows,searchValue);
        int count = customMapper.count(searchValue);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total" ,count);
        map.put("rows",customs);
        return map;
    }

    @Override
    public void insert(Custom custom) {
        customMapper.insertSelective(custom);
    }

    @Override
    public void delete(Integer[] ids) {
        for (int i = 0; i <ids.length ; i++) {
            customMapper.deleteByPrimaryKey(ids[i]+"") ;
        }
    }

    @Override
    public void update(Custom custom) {
        customMapper.updateByPrimaryKey(custom);
    }

    @Override
    public List<Custom> findAll() {
        return customMapper.findall();
    }
}