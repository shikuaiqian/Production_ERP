package com.cskaoyan.service.deviceManagement;

import com.cskaoyan.dao.deviceManagement.Device_checkMapper;
import com.cskaoyan.domain.deviceManagement.Device_check;
import com.cskaoyan.domain.deviceManagement.vo.Device_checkVo;
import com.cskaoyan.service.deviceManagement.interfaces.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {

    @Autowired
    Device_checkMapper deviceCheckMapper;

    @Override
    public List<Device_checkVo> tableInfo(String page, String rows) {
        int limit=Integer.parseInt(rows);
        int offset=(Integer.parseInt(page)-1)*limit;
        List<Device_checkVo> list=deviceCheckMapper.selectByLimitOffset(limit,offset);
        return list;
    }

    @Override
    public String tableSize() {
        return deviceCheckMapper.selectTableAmount();
    }
}
