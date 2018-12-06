package com.cskaoyan.service.qualifyMonitor.Impl;

import com.cskaoyan.dao.qualifyMonitor.UnqualifyApplyMapper;
import com.cskaoyan.domain.qualifyMonitor.UnqualifyApply;
import com.cskaoyan.service.qualifyMonitor.UnqualifyService;
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
public class UnqualifyServiceImpl implements UnqualifyService {

    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;

    @Transactional(readOnly = true)
    @Override
    public Map findPage(int page, int rows) {

        HashMap<Object, Object> map = new HashMap<>();
        HashMap<Object, Object> map2 = new HashMap<>();
        int limit = rows;
        int offset = limit*(page-1);
        map.put("limit",limit);
        map.put("offset",offset);
        int count = unqualifyApplyMapper.count();
        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.selectByPage(map);
        map2.put("total",count);
        map2.put("rows",unqualifyApplies);
        return map2;
    }
}
