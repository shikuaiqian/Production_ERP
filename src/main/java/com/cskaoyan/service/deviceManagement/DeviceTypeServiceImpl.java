package com.cskaoyan.service.deviceManagement;

import com.cskaoyan.dao.deviceManagement.Device_typeMapper;
import com.cskaoyan.domain.deviceManagement.Device_type;
import com.cskaoyan.service.deviceManagement.interfaces.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {

    @Autowired
    Device_typeMapper deviceTypeMapper;
    @Override
    public List<Device_type> tableInfo(String page, String rows) {
        int limit=Integer.parseInt(rows);
        int offset=(Integer.parseInt(page)-1)*limit;
        List<Device_type> list=deviceTypeMapper.selectByLimitOffset(limit,offset);
        return list;
    }
}
