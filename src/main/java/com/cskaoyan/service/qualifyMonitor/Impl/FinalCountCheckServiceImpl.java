package com.cskaoyan.service.qualifyMonitor.Impl;

import com.cskaoyan.dao.qualifyMonitor.FinalCountCheckMapper;

import com.cskaoyan.domain.qualifyMonitor.FinalCountCheck;

import com.cskaoyan.service.qualifyMonitor.FinalCountCheckService;
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
public class FinalCountCheckServiceImpl implements FinalCountCheckService {
    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;
    @Transactional(readOnly = true)
    @Override
    public PageInfo<FinalCountCheck> findPage(int page, int rows) {

        PageHelper.startPage(page, rows);
        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.selectByPageAndSelections();
        PageInfo<FinalCountCheck> pageInfo = new PageInfo<>(finalCountChecks);
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
        int count = finalCountCheckMapper.count(map);
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

    @Override
    public void edit(FinalCountCheck finalCountCheck) throws Exception {
        if (finalCountCheckMapper.updateByPrimaryKeySelective(finalCountCheck)!=1)
            throw new Exception("修改失败");
    }

    @Override
    @Transactional
    public void delete(String[] id) throws Exception {
        for (String i : id) {
            if (finalCountCheckMapper.deleteByPrimaryKey(i)!=1)
                throw new Exception("删除失败");
        }
    }
    @Override
    public void updateNote(String id, String note) throws Exception {
        if (finalCountCheckMapper.updateNote(id,note)!=1)
            throw new Exception("更新备注失败");
    }
}
