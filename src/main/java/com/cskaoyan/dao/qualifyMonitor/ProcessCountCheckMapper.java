package com.cskaoyan.dao.qualifyMonitor;

import com.cskaoyan.domain.qualifyMonitor.ProcessCountCheck;

public interface ProcessCountCheckMapper {
    int deleteByPrimaryKey(String pCountCheckId);

    int insert(ProcessCountCheck record);

    int insertSelective(ProcessCountCheck record);

    ProcessCountCheck selectByPrimaryKey(String pCountCheckId);

    int updateByPrimaryKeySelective(ProcessCountCheck record);

    int updateByPrimaryKey(ProcessCountCheck record);
}