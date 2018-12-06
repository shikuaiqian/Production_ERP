package com.cskaoyan.dao.deviceManagement;

import com.cskaoyan.domain.deviceManagement.Device_maintain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Device_maintainMapper {
    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(Device_maintain record);

    int insertSelective(Device_maintain record);

    Device_maintain selectByPrimaryKey(String deviceMaintainId);

    int updateByPrimaryKeySelective(Device_maintain record);

    int updateByPrimaryKey(Device_maintain record);

    List<Device_maintain> selectByLimitOffset(@Param("limit") int limit, @Param("offset") int offset);
}