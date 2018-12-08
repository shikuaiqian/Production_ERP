package com.cskaoyan.dao.deviceManagement;

import com.cskaoyan.domain.deviceManagement.Device;
import com.cskaoyan.domain.deviceManagement.vo.DeviceVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceMapper {
    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

    String selectTableAmount();

    List<DeviceVo> selectByLimitOffset(@Param("limit") int limit,@Param("offset") int offset);

    List<Device> getIdMappingName();

    List<DeviceVo> selectByMultiCondition(@Param("limit") int limit
            ,@Param("offset") int offset, @Param("SearchVo")DeviceVo deviceVo);

    String selectTableAmountByMultiCondition(@Param("SearchVo")DeviceVo deviceVo);
}