package com.cskaoyan.dao.qualifyMonitor;

import com.cskaoyan.domain.qualifyMonitor.FinalMeasuretCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FinalMeasuretCheckMapper {
    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuretCheck record);

    int insertSelective(FinalMeasuretCheck record);

    FinalMeasuretCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByPrimaryKeySelective(FinalMeasuretCheck record);

    int updateByPrimaryKey(FinalMeasuretCheck record);
    List<FinalMeasuretCheck> selectByPage(@Param("params") Map<Object,Object> map);
    int count();
}