package com.cskaoyan.service.deviceManagement.interfaces;

import com.cskaoyan.domain.deviceManagement.Device_type;


import java.util.List;

public interface DeviceTypeService {
    List<Device_type> tableInfo(String page, String rows);

    String tableSize();
}
