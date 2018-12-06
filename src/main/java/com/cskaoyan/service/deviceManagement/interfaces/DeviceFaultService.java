package com.cskaoyan.service.deviceManagement.interfaces;

import com.cskaoyan.domain.deviceManagement.Device_fault;
import com.cskaoyan.domain.deviceManagement.vo.Device_faultVo;


import java.util.List;

public interface DeviceFaultService {
    List<Device_faultVo> tableInfo(String page, String rows);

    String tableSize();

}
