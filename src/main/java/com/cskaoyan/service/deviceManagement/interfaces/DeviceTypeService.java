package com.cskaoyan.service.deviceManagement.interfaces;

import com.cskaoyan.domain.deviceManagement.Device_type;
import com.cskaoyan.domain.deviceManagement.vo.ChangeResult;


import java.util.List;

public interface DeviceTypeService {
    List<Device_type> tableInfo(String page, String rows);

    String tableSize();

    String addJudge(String userId);

    List<Device_type> getIdMappingName();

    ChangeResult insert(Device_type deviceType);

    String editJudge(String userId);

    ChangeResult update(Device_type deviceType);

    String deleteJudge(String userId);

    ChangeResult deleteBatch(List<String> deleteList);

    List<Device_type> searchDeviceByDeviceTypeId(String page, String rows, String searchValue);

    String tableSizeByDeviceTypeId(String searchValue);

    List<Device_type> searchDeviceByDeviceTypeName(String page, String rows, String searchValue);

    String tableSizeByDeviceTypeName(String searchValue);
}
