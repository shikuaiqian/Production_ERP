package com.cskaoyan.service.deviceManagement;

import com.cskaoyan.dao.deviceManagement.Device_maintainMapper;
import com.cskaoyan.domain.deviceManagement.Device_maintain;
import com.cskaoyan.service.deviceManagement.interfaces.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {

    @Autowired
    Device_maintainMapper deviceMaintainMapper;
    @Override
    public List<Device_maintain> tableInfo(String page, String rows) {
        int limit=Integer.parseInt(rows);
        int offset=(Integer.parseInt(page)-1)*limit;
        List<Device_maintain> list=deviceMaintainMapper.selectByLimitOffset(limit,offset);
        return list;
    }
}
