package com.cskaoyan.service.designSchedule.imp;

import com.cskaoyan.domain.designScheduleDomain.Custom;
import com.cskaoyan.dao.designSchedule.CustomMapper;
import com.cskaoyan.service.designSchedule.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("custom")
public class CustomServiecimp  implements CustomService{
    @Autowired
    CustomMapper  customMapper;
    @Override
    public Map<String, Object> selectByPage(String page1, String rows1) {
        int page = Integer.parseInt(page1);
        int rows = Integer.parseInt(rows1);
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
    public Map<String, Object> selectByIdandPage(HashMap<String, String>  searchValue, String page1, String rows1) {
        Map<String, Object> stringObjectMap = selectBySearchValueandPage(searchValue, page1, rows1);
        return stringObjectMap;
    }

    @Override
    public void insert(Custom custom) {
        customMapper.insertSelective(custom);
    }

    @Override
    public void delete(String[] ids) {
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

    @Override
    public Map<String, Object> selectBySearchValueandPage(HashMap<String, String> ret, String page1, String rows1) {
        int page = Integer.parseInt(page1);
        int rows = Integer.parseInt(rows1);
        int i = (page - 1) * rows;
        int offset=i>0?i:0;
        List<Custom> customs = customMapper.selectByPage(offset,rows,ret);
        int count = customMapper.count(ret);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total" ,count);
        map.put("rows",customs);
        return map;
    }
}
