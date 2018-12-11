package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.domain.qualifyMonitor.FinalCountCheck;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * Created by LZH on 2018/12/6
 */
public interface FinalCountCheckService {
    PageInfo<FinalCountCheck> findPage(int page, int rows);
    Map<Object, Object> Search(String red,String searchValue,int page, int rows);
    void add(FinalCountCheck finalCountCheck) throws Exception;
    void edit(FinalCountCheck finalCountCheck) throws Exception;
    void delete(String[] id) throws Exception;
    void updateNote(String id,String note) throws Exception;
}
