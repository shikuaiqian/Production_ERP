package com.cskaoyan.service.technologyMonitor.Impl;

import com.cskaoyan.dao.technologyMonitor.TechnologyMapper;
import com.cskaoyan.dao.technologyMonitor.TechnologyRequirementMapper;
import com.cskaoyan.domain.technologyMonitor.Technology;
import com.cskaoyan.domain.technologyMonitor.TechnologyExample;
import com.cskaoyan.domain.technologyMonitor.TechnologyRequirement;
import com.cskaoyan.domain.technologyMonitor.TechnologyRequirementExample;
import com.cskaoyan.service.technologyMonitor.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {

    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;

    @Autowired
    TechnologyRequirementExample technologyRequirementExample;

    @Override
    public Map selectTechnologyRequirementByPage(Integer page, Integer rows) {
        HashMap map = new HashMap();
        Integer startRow = (page-1)*rows;

        technologyRequirementExample.setStartRow(startRow);
        technologyRequirementExample.setPageSize(rows);
        technologyRequirementExample.setMultiTable("technology");
        technologyRequirementExample.setMultiParamName("technology_name");
        List<TechnologyRequirement> technologies = technologyRequirementMapper.selectByExample(technologyRequirementExample);
        technologyRequirementExample.clear();
        long l = technologyRequirementMapper.countByExample(technologyRequirementExample);
        map.put("rows",technologies);
        map.put("total",l);

        return map;
    }

    @Override
    public HashMap searchTechnologyRequirementById(String searchValue, Integer page, Integer rows) {
        String technologyRequirementId = "%"+searchValue+"%";
        Integer startRow = (page-1)*rows;

        technologyRequirementExample.setStartRow(startRow);
        technologyRequirementExample.setPageSize(rows);
        HashMap map = new HashMap();
        TechnologyRequirementExample.Criteria criteria = technologyRequirementExample.createCriteria();
        criteria.andTechnologyRequirementIdLike(technologyRequirementId);
        List<TechnologyRequirement> technologies = technologyRequirementMapper.selectByExample(technologyRequirementExample);
        long l = technologyRequirementMapper.countByExample(technologyRequirementExample);
        technologyRequirementExample.clear();
        map.put("rows",technologies);
        map.put("total",l);
        return map;
    }

    @Override
    public HashMap searchTechnologyRequirementByName(String searchValue, Integer page, Integer rows) {
        String technologyName = "%"+searchValue+"%";
        Integer startRow = (page-1)*rows;

        technologyRequirementExample.setStartRow(startRow);
        technologyRequirementExample.setPageSize(rows);
        HashMap map = new HashMap();
        List<TechnologyRequirement> technologies = technologyRequirementMapper.selectByTechnologyName(technologyName,startRow,rows);;
        long l = technologyRequirementMapper.countByExample(technologyRequirementExample);
        technologyRequirementExample.clear();
        map.put("rows",technologies);
        map.put("total",l);
        return map;
    }

    @Override
    @Transactional
    public boolean deleteTechnologyByID(String[] ids) {
        int b =0;
        for (int i = 0; i <ids.length ; i++) {
            b = technologyRequirementMapper.deleteByPrimaryKey(ids[i]);
        }
        return b==1;
    }

    @Override
    public boolean insertTechnology(TechnologyRequirement technologyRequirement) {
        int i = technologyRequirementMapper.insertSelective(technologyRequirement);
        return i==1;
    }

    @Override
    public boolean updateTechnologyRequirementById(TechnologyRequirement technologyRequirement) {
        int i = technologyRequirementMapper.updateByPrimaryKeySelective(technologyRequirement);
        return i==1;
    }

    @Override
    public List selectTechnologyAll() {
        technologyRequirementExample.setMultiParamName("technology_name");
        technologyRequirementExample.setMultiTable("technology");
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.selectByExample(technologyRequirementExample);
        technologyRequirementExample.clear();
        return technologyRequirements;
    }

    @Override
    public boolean updateRequirement(String technologyRequirementId, String requirement) {
        TechnologyRequirement technologyRequirement = new TechnologyRequirement();
        technologyRequirement.setTechnologyRequirementId(technologyRequirementId);
        technologyRequirement.setRequirement(requirement);
        int i = technologyRequirementMapper.updateByPrimaryKeySelective(technologyRequirement);
        return i==1;
    }
}
