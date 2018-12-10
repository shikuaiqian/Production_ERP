package com.cskaoyan.service.technologyMonitor;

import com.cskaoyan.domain.technologyMonitor.Process;
import com.cskaoyan.domain.technologyMonitor.Technology;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProcessService {
    public Map selectProcessByPage(Integer page, Integer rows);

    List selectProcessAll();

    HashMap searchProcessByTechnologyPlanId(String searchValue, Integer page, Integer rows);

    HashMap searchProcessByProcessId(String searchValue, Integer page, Integer rows);

    boolean deleteProcessByIds(String[] ids);

    boolean insertProcess(Process process);

    boolean updateProcessById(Process process);

    Process selectProcessByProcessId(String id);
}
