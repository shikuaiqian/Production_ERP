package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.domain.qualifyMonitor.FinalMeasuretCheck;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * Created by LZH on 2018/12/6
 */
public interface FinishmeasureService {
    PageInfo<FinalMeasuretCheck> findPage(int page, int rows);
    Map<Object, Object> Search(String red,String searchValue,int page, int rows);
    void add(FinalMeasuretCheck finalMeasuretCheck) throws Exception;
    void edit(FinalMeasuretCheck finalMeasuretCheck) throws Exception;
    void delete(String[] id) throws Exception;
    void updateNote(String id,String note) throws Exception;
}
