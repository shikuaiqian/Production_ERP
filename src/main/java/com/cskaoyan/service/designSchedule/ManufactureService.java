package com.cskaoyan.service.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Manufacture;


import java.util.List;
import java.util.Map;

public interface ManufactureService {
    Map<String,Object> selectByPage(String page, String rows);

    Map<String,Object> selectBySearchValue(Map<String, Object> ret, String page, String rows);

    void insert(Manufacture manufacture);

    void delete(String[] ids);

    void update(Manufacture manufacture);

    List<Manufacture> findAll();

    Manufacture getManufactureById(String manufactureId);
}
