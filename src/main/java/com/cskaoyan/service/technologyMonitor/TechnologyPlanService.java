package com.cskaoyan.service.technologyMonitor;

import com.cskaoyan.domain.technologyMonitor.TechnologyPlan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TechnologyPlanService {
    public Map selectTechnologyPlanByPage(Integer page, Integer rows);

    HashMap searchTechnologPlanyByTechnologyPlanId(String searchValue, Integer page, Integer rows);

    HashMap searchTechnologyPlanByTechnologyName(String searchValue, Integer page, Integer rows);

    boolean deleteTechnologyPlanByID(String[] ids);

    boolean insertTechnologyPlan(TechnologyPlan technology);

    boolean updateTechnologyPlanById(TechnologyPlan technology);

    List selectTechnologyPlanAll();

    TechnologyPlan selectTechnologyPlanByTechnologyPlanId(String id);
}
