package com.cskaoyan.service.deviceManagement;

import com.cskaoyan.dao.deviceManagement.Device_faultMapper;
import com.cskaoyan.domain.deviceManagement.Device_fault;
import com.cskaoyan.domain.deviceManagement.vo.Device_faultVo;
import com.cskaoyan.domain.deviceManagement.vo.ChangeResult;
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

    @Override
    public String addJudge(String userId) {
        return null;
    }

    @Override
    public String editJudge(String userId) {
        return null;
    }

    @Override
    public String deleteJudge(String userId) { return null; }

    @Override
    public ChangeResult update(Device_fault deviceFault) {
        ChangeResult changeResult = new ChangeResult("200", "OK", null);
        deviceFaultMapper.updateByPrimaryKey(deviceFault);
        return changeResult;
    }

    @Override
    public List getIdMappingName() {
        return deviceFaultMapper.getIdMappingName();
    }

    @Override
    public ChangeResult insert(Device_fault deviceFault) {
        List<Device_fault> getIdMappingName = deviceFaultMapper.getIdMappingName();
        ChangeResult changeResult = new ChangeResult("200", "OK", null);
        String status="200";
        for(int i=0;i<getIdMappingName.size();i++){
            Device_fault deviceFault1 = getIdMappingName.get(i);
            if(deviceFault1.getDeviceFaultId().equals(deviceFault1.getDeviceFaultId())){
                status="0";
                changeResult.setStatus(status);
                changeResult.setMsg("设备例检编号已存在，请更换");
                break;
            }
        }
        if(status.equals("200")){
            deviceFaultMapper.insert(deviceFault);
        }
        return changeResult;
    }

    @Override
    public ChangeResult deleteBatch(List<String> deleteList) {
        ChangeResult changeResult = new ChangeResult("200", "OK", null);
        for (int i=0;i<deleteList.size();i++){
            deviceFaultMapper.deleteByPrimaryKey(deleteList.get(i));
        }
        return changeResult;
    }

    @Override
    public List<Device_faultVo> searchDeviceByDeviceFaultId(String page, String rows, String searchValue) {
        int limit=Integer.parseInt(rows);
        int offset=(Integer.parseInt(page)-1)*limit;
        Device_faultVo deviceFaultVo = new Device_faultVo();
        deviceFaultVo.setDeviceFaultId(searchValue);
        List<Device_faultVo> list=deviceFaultMapper.selectByMultiCondition(limit,offset,deviceFaultVo);
        return list;
    }

    @Override
    public String tableSizeByDeviceFaultId(String searchValue) {
        Device_faultVo deviceFaultVo = new Device_faultVo();
        deviceFaultVo.setDeviceFaultId(searchValue);
        return deviceFaultMapper.selectTableAmountByMultiCondition(deviceFaultVo);
    }

    @Override
    public List<Device_faultVo> searchDeviceByDeviceName(String page, String rows, String searchValue) {
        int limit=Integer.parseInt(rows);
        int offset=(Integer.parseInt(page)-1)*limit;
        Device_faultVo deviceFaultVo = new Device_faultVo();
        deviceFaultVo.setDeviceName(searchValue);
        List<Device_faultVo> list=deviceFaultMapper.selectByMultiCondition(limit,offset,deviceFaultVo);
        return list;
    }

    @Override
    public String tableSizeByDeviceName(String searchValue) {
        Device_faultVo deviceFaultVo = new Device_faultVo();
        deviceFaultVo.setDeviceName(searchValue);
        return deviceFaultMapper.selectTableAmountByMultiCondition(deviceFaultVo);
    }

    @Override
    public Device_fault getObjectByPrimaryKey(String primaryKey) {
        return  deviceFaultMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public ChangeResult updateFaultDetail(String deviceFaultId, String deviceFaultDetail) {
        ChangeResult changeResult = new ChangeResult("200", "OK", null);
        Device_fault deviceFault = new Device_fault();
        deviceFault.setDeviceFaultId(deviceFaultId);
        deviceFault.setDeviceFaultDetail(deviceFaultDetail);
        deviceFaultMapper.updateByPrimaryKeySelective(deviceFault);
        return changeResult;
    }
}
