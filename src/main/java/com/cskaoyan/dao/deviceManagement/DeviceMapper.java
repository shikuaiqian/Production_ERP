package com.cskaoyan.dao.deviceManagement;

import com.cskaoyan.domain.deviceManagement.Device;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceMapper {
    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

    List<Device> selectByLimitOffset(@Param("limit") int limit,@Param("offset") int offset);
}