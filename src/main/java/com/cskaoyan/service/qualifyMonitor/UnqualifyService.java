package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.domain.qualifyMonitor.UnqualifyApply;

import java.util.Map;

/**
 * Created by LZH on 2018/12/6
 */
public interface UnqualifyService {

    Map<Object, Object> findPage(int page, int rows);

    void add(UnqualifyApply unqualifyApply) throws Exception;
    void edit(UnqualifyApply unqualifyApply) throws Exception;
}
