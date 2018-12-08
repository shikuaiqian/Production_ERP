package com.cskaoyan.service.deviceManagement.interfaces;

import com.cskaoyan.domain.deviceManagement.Device;
import com.cskaoyan.domain.deviceManagement.vo.DeviceVo;
import com.cskaoyan.domain.deviceManagement.vo.ChangeResult;

import java.util.List;

public interface DeviceListService {

    List<DeviceVo> tableInfo(String page, String rows);

    String tableSize();

    String addJudge(String userId);

    List<Device> getIdMappingName();

    ChangeResult insert(Device device);

    String editJudge(String userId);

    ChangeResult update(Device device);

    String deleteJudge(String userId);

    ChangeResult deleteBatch(List<String> deleteList);

    List<DeviceVo> searchDeviceByDeviceId(String page, String rows, String searchValue);

    String tableSizeByDeviceId(String searchValue);

    List<DeviceVo> searchDeviceByDeviceName(String page, String rows, String searchValue);

    String tableSizeByDeviceName(String searchValue);

    List<DeviceVo> searchDeviceByDeviceTypeName(String page, String rows, String searchValue);

    String tableSizeByDeviceTypeName(String searchValue);

    Device getObjectByPrimaryKey(String primaryKey);

    ChangeResult updateNote(String deviceId, String note);
}
