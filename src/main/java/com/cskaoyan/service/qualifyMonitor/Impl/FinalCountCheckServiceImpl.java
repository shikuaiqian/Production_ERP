package com.cskaoyan.service.qualifyMonitor.Impl;

import com.cskaoyan.dao.qualifyMonitor.FinalCountCheckMapper;

import com.cskaoyan.domain.qualifyMonitor.FinalCountCheck;

import com.cskaoyan.service.qualifyMonitor.FinalCountCheckService;
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
public class FinalCountCheckServiceImpl implements FinalCountCheckService {
    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;
    @Transactional(readOnly = true)
    @Override
    public Map findPage(int page, int rows) {

        HashMap<Object, Object> map = new HashMap<>();
        HashMap<Object, Object> map2 = new HashMap<>();
        int limit = rows;
        int offset = limit*(page-1);
        map.put("limit",limit);
        map.put("offset",offset);
        int count = finalCountCheckMapper.count();
        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.selectByPage(map);
        map2.put("total",count);
        map2.put("rows",finalCountChecks);
        return map2;
    }

    @Override
    public void add(FinalCountCheck finalCountCheck) throws Exception{
        if (finalCountCheckMapper.insert(finalCountCheck)!=1)
            throw new Exception("添加失败");
    }
}
