package com.cskaoyan.dao.technologyMonitor;

import com.cskaoyan.domain.technologyMonitor.TechnologyPlan;
import com.cskaoyan.domain.technologyMonitor.TechnologyPlanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyPlanMapper {
    long countByExample(TechnologyPlanExample example);

    int deleteByExample(TechnologyPlanExample example);

    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    List<TechnologyPlan> selectByExample(TechnologyPlanExample example);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByExampleSelective(@Param("record") TechnologyPlan record, @Param("example") TechnologyPlanExample example);

    int updateByExample(@Param("record") TechnologyPlan record, @Param("example") TechnologyPlanExample example);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);

    List<TechnologyPlan> selectByTechnologyName(@Param("technologyName") String technologyName,@Param("startRow") Integer startRow,@Param("rows") Integer rows);
}