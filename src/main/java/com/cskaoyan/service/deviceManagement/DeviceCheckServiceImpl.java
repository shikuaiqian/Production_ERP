package com.cskaoyan.service.deviceManagement;

import com.cskaoyan.dao.deviceManagement.Device_checkMapper;
import com.cskaoyan.domain.deviceManagement.Device_check;
import com.cskaoyan.domain.deviceManagement.vo.Device_checkVo;
import com.cskaoyan.domain.deviceManagement.vo.ChangeResult;
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

    @Override
    public String addJudge(String userId) {
        return null;
    }

    @Override
    public String editJudge(String userId) {
        return null;
    }

    @Override
    public String deleteJudge(String userId) {
        return null;
    }

    @Override
    public ChangeResult deleteBatch(List<String> deleteList) {
        ChangeResult changeResult = new ChangeResult("200", "OK", null);
        for (int i=0;i<deleteList.size();i++){
            deviceCheckMapper.deleteByPrimaryKey(deleteList.get(i));
        }
        return changeResult;
    }

    @Override
    public List<Device_checkVo> searchDeviceByDeviceCheckId(String page, String rows, String searchValue) {
        int limit=Integer.parseInt(rows);
        int offset=(Integer.parseInt(page)-1)*limit;
        Device_checkVo deviceCheckVo = new Device_checkVo();
        deviceCheckVo.setDeviceCheckId(searchValue);
        List<Device_checkVo> list=deviceCheckMapper.selectByMultiCondition(limit,offset,deviceCheckVo);
        return list;
    }

    @Override
    public String tableSizeByDeviceCheckId(String searchValue) {
        Device_checkVo deviceCheckVo = new Device_checkVo();
        deviceCheckVo.setDeviceCheckId(searchValue);
        return deviceCheckMapper.selectTableAmountByMultiCondition(deviceCheckVo);
    }

    @Override
    public List<Device_checkVo> searchDeviceByDeviceName(String page, String rows, String searchValue) {
        int limit=Integer.parseInt(rows);
        int offset=(Integer.parseInt(page)-1)*limit;
        Device_checkVo deviceCheckVo = new Device_checkVo();
        deviceCheckVo.setDeviceName(searchValue);
        List<Device_checkVo> list=deviceCheckMapper.selectByMultiCondition(limit,offset,deviceCheckVo);
        return list;
    }

    @Override
    public String tableSizeByDeviceName(String searchValue) {
        Device_checkVo deviceCheckVo = new Device_checkVo();
        deviceCheckVo.setDeviceName(searchValue);
        return deviceCheckMapper.selectTableAmountByMultiCondition(deviceCheckVo);
    }

    @Override
    public ChangeResult updateCheckResult(String deviceCheckId, String deviceCheckResult) {
        ChangeResult changeResult = new ChangeResult("200", "OK", null);
        Device_check deviceCheck = new Device_check();
        deviceCheck.setDeviceCheckId(deviceCheckId);
        deviceCheck.setDeviceCheckResult(deviceCheckResult);
        deviceCheckMapper.updateByPrimaryKeySelective(deviceCheck);
        return changeResult;
    }

    @Override
    public ChangeResult update(Device_check deviceCheck) {
        ChangeResult changeResult = new ChangeResult("200", "OK", null);
            deviceCheckMapper.updateByPrimaryKey(deviceCheck);
        return changeResult;
    }


    @Override
    public ChangeResult insert(Device_check deviceCheck) {
        List<Device_check> getIdMappingName = deviceCheckMapper.getIdMappingName();
        ChangeResult changeResult = new ChangeResult("200", "OK", null);
        String status="200";
        for(int i=0;i<getIdMappingName.size();i++){
            Device_check deviceCheck1 = getIdMappingName.get(i);
            if(deviceCheck1.getDeviceCheckId().equals(deviceCheck1.getDeviceCheckId())){
                status="0";
                changeResult.setStatus(status);
                changeResult.setMsg("设备例检编号已存在，请更换");
                break;
            }
        }
        if(status.equals("200")){
            deviceCheckMapper.insert(deviceCheck);
        }
        return changeResult;
    }
}
