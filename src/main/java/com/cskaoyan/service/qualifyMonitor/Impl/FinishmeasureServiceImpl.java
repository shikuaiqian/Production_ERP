package com.cskaoyan.service.qualifyMonitor.Impl;


import com.cskaoyan.dao.qualifyMonitor.FinalMeasuretCheckMapper;
import com.cskaoyan.domain.qualifyMonitor.FinalMeasuretCheck;
import com.cskaoyan.service.qualifyMonitor.FinishmeasureService;
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
public class FinishmeasureServiceImpl implements FinishmeasureService {
    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;
    @Transactional(readOnly = true)
    @Override
    public Map findPage(int page, int rows) {

        HashMap<Object, Object> map = new HashMap<>();
        HashMap<Object, Object> map2 = new HashMap<>();
        int limit = rows;
        int offset = limit*(page-1);
        map.put("limit",limit);
        map.put("offset",offset);
        int count = finalMeasuretCheckMapper.count();
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.selectByPage(map);
        map2.put("total",count);
        map2.put("rows",finalMeasuretChecks);
        return map2;
    }

    @Override
    public void add(FinalMeasuretCheck finalMeasuretCheck) throws Exception{
        if (finalMeasuretCheckMapper.insert(finalMeasuretCheck)!=1)
            throw new Exception("添加失败");
    }
}
