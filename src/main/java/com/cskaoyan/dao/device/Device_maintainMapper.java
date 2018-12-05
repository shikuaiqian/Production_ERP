package com.cskaoyan.dao.device;

import com.cskaoyan.domain.device.Device_maintain;

public interface Device_maintainMapper {
    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(Device_maintain record);

    int insertSelective(Device_maintain record);

    Device_maintain selectByPrimaryKey(String deviceMaintainId);

    int updateByPrimaryKeySelective(Device_maintain record);

    int updateByPrimaryKey(Device_maintain record);
}