package com.cskaoyan.service.technologyMonitor.Impl;


import com.cskaoyan.dao.technologyMonitor.TechnologyPlanMapper;
import com.cskaoyan.domain.technologyMonitor.TechnologyPlan;
import com.cskaoyan.domain.technologyMonitor.TechnologyPlanExample;
import com.cskaoyan.service.technologyMonitor.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService {

    @Autowired
    TechnologyPlanMapper technologyPlanMapper;

    @Autowired
    TechnologyPlanExample technologyPlanExample;

    @Override
    public Map selectTechnologyPlanByPage(Integer page, Integer rows) {
        HashMap map = new HashMap();
        Integer startRow = (page-1)*rows;

        technologyPlanExample.setStartRow(startRow);
        technologyPlanExample.setPageSize(rows);
        technologyPlanExample.setMultiTable("technology");
        technologyPlanExample.setMultiParamName("technology_name");
        List<TechnologyPlan> technologies = technologyPlanMapper.selectByExample(technologyPlanExample);
        technologyPlanExample.clear();
        long l = technologyPlanMapper.countByExample(technologyPlanExample);
        map.put("rows",technologies);
        map.put("total",l);
        return map;
    }

    @Override
    public HashMap searchTechnologPlanyByTechnologyPlanId(String searchValue, Integer page, Integer rows) {
        String technologyId = "%"+searchValue+"%";
        Integer startRow = (page-1)*rows;

        technologyPlanExample.setStartRow(startRow);
        technologyPlanExample.setPageSize(rows);
        HashMap map = new HashMap();
        TechnologyPlanExample.Criteria criteria = technologyPlanExample.createCriteria();
        criteria.andTechnologyPlanIdLike(technologyId);
        List<TechnologyPlan> technologies = technologyPlanMapper.selectByExample(technologyPlanExample);
        long l = technologyPlanMapper.countByExample(technologyPlanExample);
        technologyPlanExample.clear();
        map.put("rows",technologies);
        map.put("total",l);
        return map;
    }

    @Override
    public HashMap searchTechnologyPlanByTechnologyName(String searchValue, Integer page, Integer rows) {
        String technologyName = "%"+searchValue+"%";
        Integer startRow = (page-1)*rows;

        technologyPlanExample.setStartRow(startRow);
        technologyPlanExample.setPageSize(rows);
        HashMap map = new HashMap();
        List<TechnologyPlan> technologies = technologyPlanMapper.selectByTechnologyName(technologyName,startRow,rows);
        long l = technologyPlanMapper.countByExample(technologyPlanExample);
        technologyPlanExample.clear();
        map.put("rows",technologies);
        map.put("total",l);
        return map;
    }

    @Override
    @Transactional
    public boolean deleteTechnologyPlanByID(String[] ids) {
        int b =0;
        for (int i = 0; i <ids.length ; i++) {
            b = technologyPlanMapper.deleteByPrimaryKey(ids[i]);
        }

        return b==1;
    }

    @Override
    public boolean insertTechnologyPlan(TechnologyPlan technology) {
        int i = technologyPlanMapper.insertSelective(technology);
        return i==1;
    }

    @Override
    public boolean updateTechnologyPlanById(TechnologyPlan technology) {
        int i = technologyPlanMapper.updateByPrimaryKeySelective(technology);
        return i==1;
    }

    @Override
    public List selectTechnologyPlanAll() {
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.selectByExample(technologyPlanExample);
        return technologyPlans;
    }
}
