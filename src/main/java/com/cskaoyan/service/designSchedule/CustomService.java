package com.cskaoyan.service;


import com.cskaoyan.domain.Custom;

import java.util.List;
import java.util.Map;


public   interface CustomService {

    public Map<String,Object> selectByPage(Integer page, Integer rows);

    Map<String,Object> selectByIdandPage(Integer searchValue, Integer page, Integer rows);

    void insert(Custom custom);

    void delete(Integer[] ids);

    void update(Custom custom);

    List<Custom> findAll();
}
