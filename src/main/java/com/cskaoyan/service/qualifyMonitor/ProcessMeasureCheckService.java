package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.domain.qualifyMonitor.ProcessMeasureCheck;


import java.util.Map;

/**
 * Created by LZH on 2018/12/6
 */
public interface ProcessMeasureCheckService {
    Map<Object, Object> findPage(int page, int rows);
    void add(ProcessMeasureCheck processMeasureCheck) throws Exception;
}
