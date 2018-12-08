package com.cskaoyan.dao.deviceManagement;

import com.cskaoyan.domain.deviceManagement.Device_type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Device_typeMapper {
    int deleteByPrimaryKey(String deviceTypeId);

    int insert(Device_type record);

    int insertSelective(Device_type record);

    Device_type selectByPrimaryKey(String deviceTypeId);

    int updateByPrimaryKeySelective(Device_type record);

    int updateByPrimaryKey(Device_type record);

    String selectTableAmount();

    List<Device_type> selectByLimitOffset(@Param("limit") int limit, @Param("offset") int offset);

    List<Device_type> getIdMappingName();

    List<Device_type> selectByMultiCondition(int limit, int offset, Device_type deviceType);

    String selectTableAmountByMultiCondition(Device_type deviceType);
}