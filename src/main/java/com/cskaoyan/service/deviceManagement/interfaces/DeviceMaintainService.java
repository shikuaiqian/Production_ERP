package com.cskaoyan.service.deviceManagement.interfaces;

import com.cskaoyan.domain.deviceManagement.Device_maintain;
import com.cskaoyan.domain.deviceManagement.vo.Device_maintainVo;
import com.cskaoyan.domain.deviceManagement.vo.ChangeResult;

import java.util.List;

public interface DeviceMaintainService {
    List<Device_maintainVo> tableInfo(String page, String rows);

    String tableSize();

    String addJudge(String userId);

    ChangeResult insert(Device_maintain deviceMaintain);

    String editJudge(String userId);

    ChangeResult update(Device_maintain deviceMaintain);

    String deleteJudge(String userId);

    ChangeResult deleteBatch(List<String> deleteList);

    List<Device_maintainVo> searchDeviceByDeviceMaintainId(String page, String rows, String searchValue);

    String tableSizeByDeviceMaintainId(String searchValue);

    List<Device_maintainVo> searchDeviceByDeviceFaultId(String page, String rows, String searchValue);

    String tableSizeByDeviceFaultId(String searchValue);

    ChangeResult updateNote(String deviceMaintainId, String note);
}
