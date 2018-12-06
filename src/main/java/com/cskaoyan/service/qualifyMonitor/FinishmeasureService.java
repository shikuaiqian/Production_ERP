package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.domain.qualifyMonitor.FinalMeasuretCheck;

import java.util.Map;

/**
 * Created by LZH on 2018/12/6
 */
public interface FinishmeasureService {
    Map<Object, Object> findPage(int page, int rows);
    void add(FinalMeasuretCheck finalMeasuretCheck) throws Exception;
}
