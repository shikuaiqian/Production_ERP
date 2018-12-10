package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.domain.qualifyMonitor.UnqualifyApply;
import com.github.pagehelper.PageInfo;
import com.jsptags.navigation.pager.PagerTagExtraInfo;

import java.util.Map;

/**
 * Created by LZH on 2018/12/6
 */
public interface UnqualifyService {

/*    Map<Object, Object> findPage(int page, int rows);*/
    Map<Object, Object> Search(String red,String searchValue,int page, int rows);
    void add(UnqualifyApply unqualifyApply) throws Exception;
    void edit(UnqualifyApply unqualifyApply) throws Exception;
    void delete(String[] id) throws Exception;
    void updateNote(String id,String note) throws Exception;
    PageInfo<UnqualifyApply> findPage(int page, int rows);
}
