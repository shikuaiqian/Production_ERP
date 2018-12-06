package com.cskaoyan.service.deviceManagement;

import com.cskaoyan.dao.deviceManagement.DeviceMapper;
import com.cskaoyan.domain.deviceManagement.Device;
import com.cskaoyan.service.deviceManagement.interfaces.DeviceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceListServiceImpl implements DeviceListService {

    @Autowired
    DeviceMapper deviceMapper;


    @Override
    public List<Device> tableInfo(String page, String rows) {
        int limit=Integer.parseInt(rows);
        int offset=(Integer.parseInt(page)-1)*limit;
        List<Device> list=deviceMapper.selectByLimitOffset(limit,offset);
        return list;
    }
}
