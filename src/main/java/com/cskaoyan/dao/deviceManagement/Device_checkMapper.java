package com.cskaoyan.dao.device;

import com.cskaoyan.domain.device.Device_check;

public interface Device_checkMapper {
    int deleteByPrimaryKey(String deviceCheckId);

    int insert(Device_check record);

    int insertSelective(Device_check record);

    Device_check selectByPrimaryKey(String deviceCheckId);

    int updateByPrimaryKeySelective(Device_check record);

    int updateByPrimaryKey(Device_check record);
}