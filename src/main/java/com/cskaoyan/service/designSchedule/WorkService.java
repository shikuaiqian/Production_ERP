package com.cskaoyan.service.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Work;

import java.util.List;
import java.util.Map;

public interface WorkService  {
    Map<String,Object> selectByPage(String page, String rows);

    Map<String,Object> selectBysearchValue(Map searchValue, String page, String rows);

    void insert(Work work);

    void delete(String[] ids);

    void update(Work work);

    List<Work> findAll();

    Work getWorkIdById(String workId);
}
