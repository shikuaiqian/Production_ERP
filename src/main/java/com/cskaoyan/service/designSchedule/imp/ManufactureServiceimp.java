package com.cskaoyan.service.designSchedule.imp;

import com.cskaoyan.dao.designSchedule.ManufactureMapper;
import com.cskaoyan.domain.designScheduleDomain.Manufacture;
import com.cskaoyan.domain.designScheduleDomain.ManufactureVo;
import com.cskaoyan.service.designSchedule.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManufactureServiceimp implements ManufactureService {
    @Autowired
    ManufactureMapper manufactureMapper;
    @Override
    public Map<String, Object> selectByPage(String page1, String rows1) {
        int page = Integer.parseInt(page1);
        int rows = Integer.parseInt(rows1);
        int i = (page - 1) * rows;
        int offset=i>0?i:0;
        List<ManufactureVo> manufactures = manufactureMapper.selectByPage(offset, rows, null);
        int count = manufactureMapper.count(null);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total" ,count);
        map.put("rows",manufactures);
        return map;
    }



    @Override
    public Map<String, Object> selectBySearchValue(Map searchValue, String page1, String rows1) {
        int page = Integer.parseInt(page1);
        int rows = Integer.parseInt(rows1);
        int i = (page - 1) * rows;
        int offset=i>0?i:0;
        List<ManufactureVo> manufactures = manufactureMapper.selectByPage(offset, rows, searchValue);
        int count = manufactureMapper.count(searchValue);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total" ,count);
        map.put("rows",manufactures);
        return map;
    }

    @Override
    public void insert(Manufacture manufacture) {
        manufactureMapper.insertSelective(manufacture);
    }

    @Override
    public void delete(String[] ids) {
        for (int i = 0; i <ids.length ; i++) {
            manufactureMapper.deleteByPrimaryKey(ids[i]+"") ;
        }
    }

    @Override
    public void update(Manufacture manufacture) {
        manufactureMapper.updateByPrimaryKey(manufacture);
    }

    @Override
    public List<Manufacture> findAll() {
        return manufactureMapper.findAll();
    }

    @Override
    public Manufacture getManufactureById(String manufactureId) {
        return manufactureMapper.selectByPrimaryKey(manufactureId);
    }
}
