package com.cskaoyan.service.qualifyMonitor.Impl;

import com.cskaoyan.dao.qualifyMonitor.ProcessMeasureCheckMapper;

import com.cskaoyan.domain.qualifyMonitor.ProcessMeasureCheck;

import com.cskaoyan.service.qualifyMonitor.ProcessMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LZH on 2018/12/6
 */
@Service
public class ProcessMeasureCheckServiceImpl implements ProcessMeasureCheckService {
    @Autowired
    ProcessMeasureCheckMapper processMeasureCheckMapper;
    @Transactional(readOnly = true)
    @Override
    public Map findPage(int page, int rows) {

        HashMap<Object, Object> map = new HashMap<>();
        HashMap<Object, Object> map2 = new HashMap<>();
        int limit = rows;
        int offset = limit*(page-1);
        map.put("limit",limit);
        map.put("offset",offset);
        int count = processMeasureCheckMapper.count();
        List<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckMapper.selectByPage(map);
        map2.put("total",count);
        map2.put("rows",processMeasureChecks);
        return map2;
    }



    @Override
    public void add(ProcessMeasureCheck processMeasureCheck) throws Exception{
        if(processMeasureCheckMapper.insert(processMeasureCheck)!=1){
            throw new Exception("添加失败");
        }
    }
}
