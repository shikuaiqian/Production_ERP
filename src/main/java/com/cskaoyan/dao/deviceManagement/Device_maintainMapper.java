package com.cskaoyan.dao.deviceManagement;

import com.cskaoyan.domain.deviceManagement.Device_maintain;
import com.cskaoyan.domain.deviceManagement.vo.Device_maintainVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Device_maintainMapper {
    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(Device_maintain record);

    int insertSelective(Device_maintain record);

    Device_maintain selectByPrimaryKey(String deviceMaintainId);

    int updateByPrimaryKeySelective(Device_maintain record);

    int updateByPrimaryKey(Device_maintain record);

    String selectTableAmount();

    List<Device_maintainVo> selectByLimitOffset(@Param("limit") int limit, @Param("offset") int offset);

    //    没有name属性只有id
    List<Device_maintain> getIdMappingName();

    List<Device_maintainVo> selectByMultiCondition(@Param("limit") int limit
            , @Param("offset") int offset,@Param("SearchVo") Device_maintainVo deviceMaintainVo);

    String selectTableAmountByMultiCondition(@Param("SearchVo")Device_maintainVo deviceMaintainVo);
}