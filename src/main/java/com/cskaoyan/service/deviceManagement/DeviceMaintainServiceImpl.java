package com.cskaoyan.service.deviceManagement;

import com.cskaoyan.dao.deviceManagement.Device_maintainMapper;
import com.cskaoyan.domain.deviceManagement.Device_maintain;
import com.cskaoyan.domain.deviceManagement.vo.Device_maintainVo;
import com.cskaoyan.domain.deviceManagement.vo.ChangeResult;
import com.cskaoyan.service.deviceManagement.interfaces.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {

    @Autowired
    Device_maintainMapper deviceMaintainMapper;
    @Override
    public List<Device_maintainVo> tableInfo(String page, String rows) {
        int limit=Integer.parseInt(rows);
        int offset=(Integer.parseInt(page)-1)*limit;
        List<Device_maintainVo> list=deviceMaintainMapper.selectByLimitOffset(limit,offset);
        return list;
    }

    @Override
    public String tableSize() {
        return deviceMaintainMapper.selectTableAmount();
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
    public ChangeResult update(Device_maintain deviceMaintain) {
        ChangeResult changeResult = new ChangeResult("200", "OK", null);
        deviceMaintainMapper.updateByPrimaryKey(deviceMaintain);
        return changeResult;
    }

    @Override
    public ChangeResult insert(Device_maintain deviceMaintain) {
        List<Device_maintain> getIdMappingName = deviceMaintainMapper.getIdMappingName();
        ChangeResult changeResult = new ChangeResult("200", "OK", null);
        String status="200";
        for(int i=0;i<getIdMappingName.size();i++){
            Device_maintain deviceMaintain1 = getIdMappingName.get(i);
            if(deviceMaintain1.getDeviceMaintainId().equals(deviceMaintain1.getDeviceMaintainId())){
                status="0";
                changeResult.setStatus(status);
                changeResult.setMsg("设备例检编号已存在，请更换");
                break;
            }
        }
        if(status.equals("200")){
            deviceMaintainMapper.insert(deviceMaintain);
        }
        return changeResult;
    }

    @Override
    public ChangeResult deleteBatch(List<String> deleteList) {
        ChangeResult changeResult = new ChangeResult("200", "OK", null);
        for (int i=0;i<deleteList.size();i++){
            deviceMaintainMapper.deleteByPrimaryKey(deleteList.get(i));
        }
        return changeResult;
    }

    @Override
    public List<Device_maintainVo> searchDeviceByDeviceMaintainId(String page, String rows, String searchValue) {
        int limit=Integer.parseInt(rows);
        int offset=(Integer.parseInt(page)-1)*limit;
        Device_maintainVo deviceMaintainVo = new Device_maintainVo();
        deviceMaintainVo.setDeviceMaintainId(searchValue);
        List<Device_maintainVo> list=deviceMaintainMapper.selectByMultiCondition(limit,offset,deviceMaintainVo);
        return list;
    }

    @Override
    public String tableSizeByDeviceMaintainId(String searchValue) {
        Device_maintainVo deviceMaintainVo = new Device_maintainVo();
        deviceMaintainVo.setDeviceMaintainId(searchValue);
        return deviceMaintainMapper.selectTableAmountByMultiCondition(deviceMaintainVo);
    }

    @Override
    public List<Device_maintainVo> searchDeviceByDeviceFaultId(String page, String rows, String searchValue) {
        int limit=Integer.parseInt(rows);
        int offset=(Integer.parseInt(page)-1)*limit;
        Device_maintainVo deviceMaintainVo = new Device_maintainVo();
        deviceMaintainVo.setDeviceFaultId(searchValue);
        List<Device_maintainVo> list=deviceMaintainMapper.selectByMultiCondition(limit,offset,deviceMaintainVo);
        return list;
    }

    @Override
    public String tableSizeByDeviceFaultId(String searchValue) {
        Device_maintainVo deviceMaintainVo = new Device_maintainVo();
        deviceMaintainVo.setDeviceFaultId(searchValue);
        return deviceMaintainMapper.selectTableAmountByMultiCondition(deviceMaintainVo);
    }

    @Override
    public ChangeResult updateNote(String deviceMaintainId, String note) {
        ChangeResult changeResult = new ChangeResult("200", "OK", null);
        Device_maintain deviceMaintain = new Device_maintain();
        deviceMaintain.setDeviceMaintainId(deviceMaintainId);
        deviceMaintain.setNote(note);
        deviceMaintainMapper.updateByPrimaryKeySelective(deviceMaintain);
        return changeResult;
    }
}
