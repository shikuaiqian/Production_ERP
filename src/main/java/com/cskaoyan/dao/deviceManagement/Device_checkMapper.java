package com.cskaoyan.dao.deviceManagement;

import com.cskaoyan.domain.deviceManagement.Device_check;
import com.cskaoyan.domain.deviceManagement.vo.Device_checkVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Device_checkMapper {
    int deleteByPrimaryKey(String deviceCheckId);

    int insert(Device_check record);

    int insertSelective(Device_check record);

    Device_check selectByPrimaryKey(String deviceCheckId);

    int updateByPrimaryKeySelective(Device_check record);

    int updateByPrimaryKey(Device_check record);

    String selectTableAmount();

    List<Device_checkVo> selectByLimitOffset(@Param("limit") int limit, @Param("offset") int offset);

    //    没有name属性只有id
    List<Device_check> getIdMappingName();

    List<Device_checkVo> selectByMultiCondition(@Param("limit") int limit
            , @Param("offset") int offset, @Param("SearchVo")Device_checkVo deviceCheckVo);

    String selectTableAmountByMultiCondition(@Param("SearchVo")Device_checkVo deviceCheckVo);
}