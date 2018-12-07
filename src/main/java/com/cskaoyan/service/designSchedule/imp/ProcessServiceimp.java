package com.cskaoyan.service.designSchedule.imp;

import com.cskaoyan.dao.designSchedule.ProcessMapper;
import com.cskaoyan.service.designSchedule.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProcessServiceimp implements ProcessService {
    @Autowired
    ProcessMapper processMapper;
    @Override
    public List<Process> findAll() {
        return processMapper.findall();
    }
}
