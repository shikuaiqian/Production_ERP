package com.cskaoyan.dao.deviceManagement;

import com.cskaoyan.domain.deviceManagement.Device_fault;
import com.cskaoyan.domain.deviceManagement.vo.Device_faultVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Device_faultMapper {
    int deleteByPrimaryKey(String deviceFaultId);

    int insert(Device_fault record);

    int insertSelective(Device_fault record);

    Device_fault selectByPrimaryKey(String deviceFaultId);

    int updateByPrimaryKeySelective(Device_fault record);

    int updateByPrimaryKey(Device_fault record);

    String selectTableAmount();

    List<Device_faultVo> selectByLimitOffset(@Param("limit") int limit, @Param("offset") int offset);

//    没有name属性只有id
    List<Device_fault> getIdMappingName();

    List<Device_faultVo> selectByMultiCondition(int limit, int offset, Device_faultVo deviceFaultVo);

    String selectTableAmountByMultiCondition(Device_faultVo deviceFaultVo);
}