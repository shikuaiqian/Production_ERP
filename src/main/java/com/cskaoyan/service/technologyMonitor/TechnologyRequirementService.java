package com.cskaoyan.service.technologyMonitor;

import com.cskaoyan.domain.technologyMonitor.TechnologyRequirement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TechnologyRequirementService {
    public Map selectTechnologyRequirementByPage(Integer page, Integer rows);

    HashMap searchTechnologyRequirementById(String searchValue, Integer page, Integer rows);

    HashMap searchTechnologyRequirementByName(String searchValue, Integer page, Integer rows);

    boolean deleteTechnologyByID(String[] ids);

    boolean insertTechnology(TechnologyRequirement technologyRequirement);

    boolean updateTechnologyRequirementById(TechnologyRequirement technologyRequirement);

    List selectTechnologyAll();
}
