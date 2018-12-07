package com.cskaoyan.service.technologyMonitor.Impl;

import com.cskaoyan.dao.technologyMonitor.TechnologyMapper;
import com.cskaoyan.domain.technologyMonitor.Technology;
import com.cskaoyan.domain.technologyMonitor.TechnologyExample;
import com.cskaoyan.service.technologyMonitor.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Map selectTechnology(Integer page, Integer rows) {
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
}
