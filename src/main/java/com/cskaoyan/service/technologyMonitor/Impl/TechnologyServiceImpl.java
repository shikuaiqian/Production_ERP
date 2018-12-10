package com.cskaoyan.service.technologyMonitor.Impl;

import com.cskaoyan.dao.technologyMonitor.TechnologyMapper;
import com.cskaoyan.domain.technologyMonitor.Technology;
import com.cskaoyan.domain.technologyMonitor.TechnologyExample;
import com.cskaoyan.service.technologyMonitor.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    TechnologyMapper technologyMapper;

    @Autowired
    TechnologyExample technologyExample;

    @Override
    public Map selectTechnologyByPage(Integer page, Integer rows) {
        HashMap map = new HashMap();
        Integer startRow = (page-1)*rows;

        technologyExample.setStartRow(startRow);
        technologyExample.setPageSize(rows);

        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);
        technologyExample.clear();
        long l = technologyMapper.countByExample(technologyExample);
        map.put("rows",technologies);
        map.put("total",l);
        return map;
    }

    @Override
    @Transactional
    public boolean deleteTechnologyByID(String [] technologyIds) {
        int b=0;
        for (int i = 0; i <technologyIds.length; i++) {
            b = technologyMapper.deleteByPrimaryKey(technologyIds[i]);
        }
        return b==1;
    }

    @Override
    public boolean insertTechnology(Technology technology) {
        int i = technologyMapper.insertSelective(technology);
        return i==1;
    }

    @Override
    public boolean updateTechnologyById(Technology technology) {
        int i = technologyMapper.updateByPrimaryKeySelective(technology);
        return i==1;
    }

    @Override
    public List selectTechnologyAll() {
        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);
        return technologies;
    }

    @Override
    public HashMap searchTechnologyByTechnologyId(String value, Integer page, Integer row) {
        String technologyId = "%"+value+"%";
        Integer startRow = (page-1)*row;

        technologyExample.setStartRow(startRow);
        technologyExample.setPageSize(row);
        HashMap map = new HashMap();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        criteria.andTechnologyIdLike(technologyId);
        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);
        long l = technologyMapper.countByExample(technologyExample);
        technologyExample.clear();
        map.put("rows",technologies);
        map.put("total",l);
        return map;
    }

    @Override
    public HashMap searchTechnologyByTechnologyName(String value, Integer page, Integer row) {
        String technologyName = "%"+value+"%";
        Integer startRow = (page-1)*row;

        technologyExample.setStartRow(startRow);
        technologyExample.setPageSize(row);
        HashMap map = new HashMap();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        criteria.andTechnologyNameLike(technologyName);
        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);
        long l = technologyMapper.countByExample(technologyExample);
        technologyExample.clear();
        map.put("rows",technologies);
        map.put("total",l);
        return map;
    }

    @Override
    public Technology selectTechnologyByTechnologyId(String id) {
        Technology technology = technologyMapper.selectByPrimaryKey(id);
        return technology;
    }


}
