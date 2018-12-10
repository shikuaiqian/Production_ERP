package com.cskaoyan.service.qualifyMonitor.Impl;

import com.cskaoyan.dao.qualifyMonitor.UnqualifyApplyMapper;
import com.cskaoyan.domain.qualifyMonitor.UnqualifyApply;
import com.cskaoyan.service.qualifyMonitor.UnqualifyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
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
    public PageInfo<UnqualifyApply> findPage(int page, int rows) {

        PageHelper.startPage(page, rows);
        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.selectByPageAndSelections();
        PageInfo<UnqualifyApply> pageInfo = new PageInfo<>(unqualifyApplies);
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
        int count = unqualifyApplyMapper.count(map);
        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.selectByPage(map);
        map2.put("total",count);
        map2.put("rows",unqualifyApplies);
        return map2;
    }
    @Override
    public void add(UnqualifyApply unqualifyApply) throws Exception {
        if(unqualifyApplyMapper.insert(unqualifyApply)!=1){
            throw new Exception("添加失败");
        }
    }

    @Override
    public void edit(UnqualifyApply unqualifyApply) throws Exception {
        if (unqualifyApplyMapper.updateByPrimaryKeySelective(unqualifyApply)!=1)
            throw new Exception("修改失败");
    }
    @Override
    @Transactional
    public void delete(String[] id) throws Exception {
        for (String i : id) {
            if (unqualifyApplyMapper.deleteByPrimaryKey(i)!=1)
                throw new Exception("删除失败");
        }
    }

    @Override
    public void updateNote(String id, String note) throws Exception {
        if (unqualifyApplyMapper.updateNote(id,note)!=1)
            throw new Exception("修改备注失败");
    }


}
