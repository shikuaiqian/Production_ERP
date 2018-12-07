package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.domain.qualifyMonitor.FinalCountCheck;

import java.util.Map;

/**
 * Created by LZH on 2018/12/6
 */
public interface FinalCountCheckService {
    Map<Object, Object> findPage(int page, int rows);
    void add(FinalCountCheck finalCountCheck) throws Exception;
}
