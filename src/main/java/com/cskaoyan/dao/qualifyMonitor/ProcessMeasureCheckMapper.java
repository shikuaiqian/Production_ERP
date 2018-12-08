package com.cskaoyan.dao.qualifyMonitor;

import com.cskaoyan.domain.qualifyMonitor.FinalCountCheck;
import com.cskaoyan.domain.qualifyMonitor.ProcessMeasureCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface ProcessMeasureCheckMapper {
    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(ProcessMeasureCheck record);

    int insertSelective(ProcessMeasureCheck record);

    ProcessMeasureCheck selectByPrimaryKey(String pMeasureCheckId);

    int updateByPrimaryKeySelective(ProcessMeasureCheck record);

    int updateByPrimaryKey(ProcessMeasureCheck record);
    List<ProcessMeasureCheck> selectByPage(@Param("params") Map<Object,Object> map);
    int count();
}