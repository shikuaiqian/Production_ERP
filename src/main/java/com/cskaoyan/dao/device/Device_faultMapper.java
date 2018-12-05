package com.cskaoyan.dao.device;

import com.cskaoyan.domain.device.Device_fault;

public interface Device_faultMapper {
    int deleteByPrimaryKey(String deviceFaultId);

    int insert(Device_fault record);

    int insertSelective(Device_fault record);

    Device_fault selectByPrimaryKey(String deviceFaultId);

    int updateByPrimaryKeySelective(Device_fault record);

    int updateByPrimaryKey(Device_fault record);
}