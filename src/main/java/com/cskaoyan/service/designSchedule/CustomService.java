package com.cskaoyan.service.designSchedule;


import com.cskaoyan.domain.designScheduleDomain.Custom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public   interface CustomService {

    public Map<String,Object> selectByPage(String page, String rows);

    Map<String,Object> selectByIdandPage(HashMap<String, String>  searchValue, String page, String rows);

    void insert(Custom custom);

    void delete(String[] ids);

    void update(Custom custom);

    List<Custom> findAll();

    Map<String,Object> selectBySearchValueandPage(HashMap<String, String> ret, String page, String rows);

    Custom getCustomById(String customId);
}
