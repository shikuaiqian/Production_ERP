package com.cskaoyan.service.deviceManagement;

import com.cskaoyan.dao.deviceManagement.Device_typeMapper;
import com.cskaoyan.domain.deviceManagement.Device_type;
import com.cskaoyan.domain.deviceManagement.vo.ChangeResult;
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

    @Override
    public String tableSize() {
        return deviceTypeMapper.selectTableAmount();
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
    public ChangeResult update(Device_type deviceType) {
        ChangeResult changeResult = new ChangeResult("200", "OK", null);
        deviceTypeMapper.updateByPrimaryKey(deviceType);
        return changeResult;
    }

    @Override
    public List<Device_type> getIdMappingName() {
        return deviceTypeMapper.getIdMappingName();
    }

    @Override
    public ChangeResult insert(Device_type deviceType) {
        List<Device_type> idMappingName = deviceTypeMapper.getIdMappingName();
        ChangeResult changeResult = new ChangeResult("200", "OK", null);
        String status="200";
        for(int i=0;i<idMappingName.size();i++){
            Device_type deviceType1 = idMappingName.get(i);
            if(deviceType1.getDeviceTypeId().equals(deviceType.getDeviceTypeId())){
                status="0";
                changeResult.setStatus(status);
                changeResult.setMsg("设备种类编号已存在，请更换");
                break;
            }
        }
        if(status.equals("200")){
            deviceTypeMapper.insert(deviceType);
        }
        return changeResult;
    }

    @Override
    public ChangeResult deleteBatch(List<String> deleteList) {
        ChangeResult changeResult = new ChangeResult("200", "OK", null);
        for (int i=0;i<deleteList.size();i++){
            deviceTypeMapper.deleteByPrimaryKey(deleteList.get(i));
        }
        return changeResult;
    }

    @Override
    public List<Device_type> searchDeviceByDeviceTypeId(String page, String rows, String searchValue) {
        int limit=Integer.parseInt(rows);
        int offset=(Integer.parseInt(page)-1)*limit;
        Device_type deviceType = new Device_type();
        deviceType.setDeviceTypeId(searchValue);
        List<Device_type> list=deviceTypeMapper.selectByMultiCondition(limit,offset,deviceType);
        return list;
    }

    @Override
    public String tableSizeByDeviceTypeId(String searchValue) {
        Device_type deviceType = new Device_type();
        deviceType.setDeviceTypeId(searchValue);
        return deviceTypeMapper.selectTableAmountByMultiCondition(deviceType);
    }

    @Override
    public List<Device_type> searchDeviceByDeviceTypeName(String page, String rows, String searchValue) {
        int limit=Integer.parseInt(rows);
        int offset=(Integer.parseInt(page)-1)*limit;
        Device_type deviceType = new Device_type();
        deviceType.setDeviceTypeName(searchValue);
        List<Device_type> list=deviceTypeMapper.selectByMultiCondition(limit,offset,deviceType);
        return list;
    }

    @Override
    public String tableSizeByDeviceTypeName(String searchValue) {
        Device_type deviceType = new Device_type();
        deviceType.setDeviceTypeName(searchValue);
        return deviceTypeMapper.selectTableAmountByMultiCondition(deviceType);
    }

    @Override
    public Device_type getObjectByPrimaryKey(String primaryKey) {
        return deviceTypeMapper.selectByPrimaryKey(primaryKey);
    }
}
