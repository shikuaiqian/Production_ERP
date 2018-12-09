package com.cskaoyan.service.deviceManagement.interfaces;

import com.cskaoyan.domain.deviceManagement.Device_check;
import com.cskaoyan.domain.deviceManagement.vo.Device_checkVo;
import com.cskaoyan.domain.deviceManagement.vo.ChangeResult;

import java.util.List;

public interface DeviceCheckService {
    List<Device_checkVo> tableInfo(String page, String rows);

    String tableSize();

    String addJudge(String userId);

    ChangeResult insert(Device_check deviceCheck);

    String editJudge(String userId);

    ChangeResult update(Device_check deviceCheck);

    String deleteJudge(String userId);

    ChangeResult deleteBatch(List<String> deleteList);

    List<Device_checkVo> searchDeviceByDeviceCheckId(String page, String rows, String searchValue);

    String tableSizeByDeviceCheckId(String searchValue);

    List<Device_checkVo> searchDeviceByDeviceName(String page, String rows, String searchValue);

    String tableSizeByDeviceName(String searchValue);

    ChangeResult updateCheckResult(String deviceCheckId, String deviceCheckResult);
}
