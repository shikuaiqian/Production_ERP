package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.domain.qualifyMonitor.ProcessMeasureCheck;
import com.github.pagehelper.PageInfo;


import java.util.Map;

/**
 * Created by LZH on 2018/12/6
 */
public interface ProcessMeasureCheckService {
    PageInfo<ProcessMeasureCheck> findPage(int page, int rows);
    Map<Object, Object> Search(String red,String searchValue,int page, int rows);
    void add(ProcessMeasureCheck processMeasureCheck) throws Exception;
    void edit(ProcessMeasureCheck processMeasureCheck) throws Exception;
    void delete(String[] id) throws Exception;
    void updateNote(String id,String note) throws Exception;
}
