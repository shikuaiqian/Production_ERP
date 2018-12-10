package com.cskaoyan.service.qualifyMonitor.Impl;


import com.cskaoyan.dao.qualifyMonitor.FinalMeasuretCheckMapper;
import com.cskaoyan.domain.qualifyMonitor.FinalMeasuretCheck;
import com.cskaoyan.service.qualifyMonitor.FinishmeasureService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<FinalMeasuretCheck> findPage(int page, int rows) {

        PageHelper.startPage(page, rows);
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.selectByPageAndSelections();
        PageInfo<FinalMeasuretCheck> pageInfo = new PageInfo<>(finalMeasuretChecks);
        return pageInfo;
    }
    @Override
    public Map<Object, Object> Search(String red, String searchValue, int page, int rows) {
        HashMap<Object, Object> map = new HashMap<>();
        HashMap<Object, Object> map2 = new HashMap<>();
        int limit = rows;
        int offset = limit*(page-1);
        map.put("limit",limit);
        map.put("offset",offset);
        map.put(red,searchValue);
        int count = finalMeasuretCheckMapper.count(map);
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

    @Override
    public void edit(FinalMeasuretCheck finalMeasuretCheck) throws Exception {
        if (finalMeasuretCheckMapper.updateByPrimaryKeySelective(finalMeasuretCheck)!=1)
            throw new Exception("修改失败");
    }

    @Override
    @Transactional
    public void delete(String[] id) throws Exception {
        for (String i : id) {
            if (finalMeasuretCheckMapper.deleteByPrimaryKey(i)!=1)
                throw new Exception("删除失败");
        }
    }
    @Override
    public void updateNote(String id, String note) throws Exception {
        if (finalMeasuretCheckMapper.updateNote(id,note)!=1)
            throw new Exception("更新备注失败");
    }
}
