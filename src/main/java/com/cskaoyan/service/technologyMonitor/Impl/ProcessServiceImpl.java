package com.cskaoyan.service.technologyMonitor.Impl;

import com.cskaoyan.dao.technologyMonitor.ProcessMapper;
import com.cskaoyan.domain.technologyMonitor.Process;
import com.cskaoyan.domain.technologyMonitor.ProcessExample;
import com.cskaoyan.domain.technologyMonitor.Technology;
import com.cskaoyan.service.technologyMonitor.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    ProcessMapper processMapper;

    @Autowired
    ProcessExample processExample;

    @Override
    public Map selectProcessByPage(Integer page, Integer rows) {
        HashMap map = new HashMap();
        Integer startRow = (page-1)*rows;

        processExample.setStartRow(startRow);
        processExample.setPageSize(rows);

        List<Process> processes = processMapper.selectByExample(processExample);
        processExample.clear();
        long l = processMapper.countByExample(processExample);
        map.put("rows",processes);
        map.put("total",l);
        return map;
    }

    @Override
    public List selectProcessAll() {
        List<Process> processes = processMapper.selectByExample(processExample);
        return processes;
    }

    @Override
    public HashMap searchProcessByTechnologyPlanId(String searchValue, Integer page, Integer rows) {
        String technologyPlanId = "%"+searchValue+"%";
        Integer startRow = (page-1)*rows;
        HashMap map = new HashMap();

        ProcessExample.Criteria criteria = processExample.createCriteria();
        criteria.andTechnologyPlanIdLike(technologyPlanId);
        List<Process> processes = processMapper.selectByExample(processExample);
        long l = processMapper.countByExample(processExample);
        processExample.clear();
        map.put("rows",processes);
        map.put("total",l);
        return map;
    }

    @Override
    public HashMap searchProcessByProcessId(String searchValue, Integer page, Integer rows) {
        String processId = "%"+searchValue+"%";
        Integer startRow = (page-1)*rows;

        processExample.setStartRow(startRow);
        processExample.setPageSize(rows);
        HashMap map = new HashMap();
        ProcessExample.Criteria criteria = processExample.createCriteria();
        criteria.andProcessIdLike(processId);
        List<Process> technologies = processMapper.selectByExample(processExample);
        long l = processMapper.countByExample(processExample);
        processExample.clear();
        map.put("rows",technologies);
        map.put("total",l);
        return map;
    }

    @Override
    @Transactional
    public boolean deleteProcessByIds(String[] ids) {
        int b = 0;
        for (int i = 0; i <ids.length ; i++) {
           b = processMapper.deleteByPrimaryKey(ids[i]);
        }

        return b==1;
    }

    @Override
    public boolean insertProcess(Process process) {
        int i = processMapper.insertSelective(process);
        return i==1;
    }

    @Override
    public boolean updateProcessById(Process process) {
        int i = processMapper.updateByPrimaryKeySelective(process);
        return i==1;
    }

    @Override
    public Process selectProcessByProcessId(String id) {
        Process process = processMapper.selectByPrimaryKey(id);
        return process;
    }
}
