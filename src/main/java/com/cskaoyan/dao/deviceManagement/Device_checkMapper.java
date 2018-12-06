package com.cskaoyan.dao.deviceManagement;

import com.cskaoyan.domain.deviceManagement.Device_check;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Device_checkMapper {
    int deleteByPrimaryKey(String deviceCheckId);

    int insert(Device_check record);

    int insertSelective(Device_check record);

    Device_check selectByPrimaryKey(String deviceCheckId);

    int updateByPrimaryKeySelective(Device_check record);

    int updateByPrimaryKey(Device_check record);

    List<Device_check> selectByLimitOffset(@Param("limit") int limit, @Param("offset") int offset);
}