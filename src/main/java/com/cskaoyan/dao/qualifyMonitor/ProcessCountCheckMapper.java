package com.cskaoyan.dao.qualifyMonitor;

import com.cskaoyan.domain.qualifyMonitor.FinalCountCheck;
import com.cskaoyan.domain.qualifyMonitor.ProcessCountCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProcessCountCheckMapper {
    int deleteByPrimaryKey(String pCountCheckId);

    int insert(ProcessCountCheck record);

    int insertSelective(ProcessCountCheck record);

    ProcessCountCheck selectByPrimaryKey(String pCountCheckId);

    int updateByPrimaryKeySelective(ProcessCountCheck record);

    int updateByPrimaryKey(ProcessCountCheck record);
    List<ProcessCountCheck> selectByPage(@Param("params") Map<Object,Object> map);
    int count();
}