package com.cskaoyan.service.technologyMonitor;

import com.cskaoyan.domain.technologyMonitor.Technology;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TechnologyService {
    public Map selectTechnologyByPage(Integer page,Integer rows);

    boolean deleteTechnologyByID(String [] technologyId);

    boolean insertTechnology(Technology technology);

    boolean updateTechnologyById(Technology technology);

    List selectTechnologyAll();

    HashMap searchTechnologyByTechnologyId(String value, Integer page, Integer row);

    HashMap searchTechnologyByTechnologyName(String value, Integer page, Integer row);

   Technology selectTechnologyByTechnologyId(String  id);
}
