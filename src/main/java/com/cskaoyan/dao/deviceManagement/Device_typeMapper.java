package com.cskaoyan.dao.device;

import com.cskaoyan.domain.device.Device_type;

public interface Device_typeMapper {
    int deleteByPrimaryKey(String deviceTypeId);

    int insert(Device_type record);

    int insertSelective(Device_type record);

    Device_type selectByPrimaryKey(String deviceTypeId);

    int updateByPrimaryKeySelective(Device_type record);

    int updateByPrimaryKey(Device_type record);
}