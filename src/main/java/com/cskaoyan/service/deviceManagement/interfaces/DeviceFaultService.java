package com.cskaoyan.service.deviceManagement.interfaces;
import com.cskaoyan.domain.deviceManagement.Device_fault;
import com.cskaoyan.domain.deviceManagement.vo.Device_faultVo;
import com.cskaoyan.domain.deviceManagement.vo.ChangeResult;


import java.util.List;

public interface DeviceFaultService {
    List<Device_faultVo> tableInfo(String page, String rows);

    String tableSize();

    String addJudge(String userId);

    List getIdMappingName();

    ChangeResult insert(Device_fault deviceFault);

    String editJudge(String userId);

    ChangeResult update(Device_fault deviceFault);

    String deleteJudge(String userId);

    ChangeResult deleteBatch(List<String> deleteList);

    List<Device_faultVo> searchDeviceByFaultId(String page, String rows, String searchValue);

    String tableSizeByFaultId(String searchValue);

    List<Device_faultVo> searchDeviceByDeviceName(String page, String rows, String searchValue);

    String tableSizeByDeviceName(String searchValue);
}
