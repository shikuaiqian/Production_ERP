package com.cskaoyan.service.deviceManagement;

import com.cskaoyan.dao.deviceManagement.Device_faultMapper;
import com.cskaoyan.domain.deviceManagement.Device_fault;
import com.cskaoyan.domain.deviceManagement.vo.Device_faultVo;
import com.cskaoyan.service.deviceManagement.interfaces.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {

    @Autowired
    Device_faultMapper deviceFaultMapper;

    @Override
    public List<Device_faultVo> tableInfo(String page, String rows) {
        int limit=Integer.parseInt(rows);
        int offset=(Integer.parseInt(page)-1)*limit;
        List<Device_faultVo> list=deviceFaultMapper.selectByLimitOffset(limit,offset);
        return list;
    }

    @Override
    public String tableSize() {
        return deviceFaultMapper.selectTableAmount();
    }
}
