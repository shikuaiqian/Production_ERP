package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.domain.qualifyMonitor.ProcessCountCheck;

import java.util.Map;

/**
 * Created by LZH on 2018/12/6
 */
public interface ProcessCountCheckService {
    Map<Object, Object> findPage(int page, int rows);
    void add(ProcessCountCheck processCountCheck) throws Exception;
}
