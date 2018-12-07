package com.cskaoyan.service.qualifyMonitor.Impl;

import com.cskaoyan.dao.qualifyMonitor.ProcessCountCheckMapper;

import com.cskaoyan.domain.qualifyMonitor.ProcessCountCheck;
import com.cskaoyan.service.qualifyMonitor.ProcessCountCheckService;
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
public class ProcessCountCheckServiceImpl implements ProcessCountCheckService {
    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;
    @Transactional(readOnly = true)
    @Override
    public Map findPage(int page, int rows) {

        HashMap<Object, Object> map = new HashMap<>();
        HashMap<Object, Object> map2 = new HashMap<>();
        int limit = rows;
        int offset = limit*(page-1);
        map.put("limit",limit);
        map.put("offset",offset);
        int count = processCountCheckMapper.count();
        List<ProcessCountCheck> processCountChecks = processCountCheckMapper.selectByPage(map);
        map2.put("total",count);
        map2.put("rows",processCountChecks);
        return map2;
    }

    @Override
    public void add(ProcessCountCheck processCountCheck) throws Exception{
        if (processCountCheckMapper.insert(processCountCheck)!=1)
            throw new Exception("添加失败");
    }
}