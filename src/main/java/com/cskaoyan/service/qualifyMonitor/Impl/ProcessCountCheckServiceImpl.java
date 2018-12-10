package com.cskaoyan.service.qualifyMonitor.Impl;

import com.cskaoyan.dao.qualifyMonitor.ProcessCountCheckMapper;

import com.cskaoyan.domain.qualifyMonitor.ProcessCountCheck;
import com.cskaoyan.service.qualifyMonitor.ProcessCountCheckService;
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
public class ProcessCountCheckServiceImpl implements ProcessCountCheckService {
    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;
    @Transactional(readOnly = true)
    @Override
    public PageInfo<ProcessCountCheck> findPage(int page, int rows) {

        PageHelper.startPage(page, rows);
        List<ProcessCountCheck> processMeasureChecks = processCountCheckMapper.selectByPageAndSelections();
        PageInfo<ProcessCountCheck> pageInfo = new PageInfo<>(processMeasureChecks);
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
        int count = processCountCheckMapper.count(map);
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

    @Override
    public void edit(ProcessCountCheck processCountCheck) throws Exception {
        if (processCountCheckMapper.updateByPrimaryKeySelective(processCountCheck)!=1)
            throw new Exception("修改失败");
    }
    @Override
    @Transactional
    public void delete(String[] id) throws Exception {
        for (String i : id) {
            if (processCountCheckMapper.deleteByPrimaryKey(i)!=1)
                throw new Exception("删除失败");
        }
    }
    @Override
    public void updateNote(String id, String note) throws Exception {
        if (processCountCheckMapper.updateNote(id,note)!=1)
            throw new Exception("更新备注失败");
    }
}
