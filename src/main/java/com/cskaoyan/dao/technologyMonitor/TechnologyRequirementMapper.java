package com.cskaoyan.dao.technologyMonitor;

import com.cskaoyan.domain.technologyMonitor.TechnologyRequirement;
import com.cskaoyan.domain.technologyMonitor.TechnologyRequirementExample;
import com.cskaoyan.service.technologyMonitor.TechnologyRequirementService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyRequirementMapper {
    long countByExample(TechnologyRequirementExample example);

    int deleteByExample(TechnologyRequirementExample example);

    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    List<TechnologyRequirement> selectByExample(TechnologyRequirementExample example);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByExampleSelective(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByExample(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);

    List<TechnologyRequirement> selectByTechnologyName(@Param("technologyName") String technologyName,@Param("startRow") Integer startRow,@Param("rows") Integer rows);
}