package com.cskaoyan.service.deviceManagement;

import com.cskaoyan.dao.deviceManagement.DeviceMapper;
import com.cskaoyan.domain.deviceManagement.Device;
import com.cskaoyan.domain.deviceManagement.vo.DeviceVo;
import com.cskaoyan.domain.deviceManagement.vo.ChangeResult;
import com.cskaoyan.service.deviceManagement.interfaces.DeviceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceListServiceImpl implements DeviceListService {

    @Autowired
    DeviceMapper deviceMapper;


    @Override
    public List<DeviceVo> tableInfo(String page, String rows) {
        int limit=Integer.parseInt(rows);
        int offset=(Integer.parseInt(page)-1)*limit;
        List<DeviceVo> list=deviceMapper.selectByLimitOffset(limit,offset);
        System.out.println(list);
        return list;
    }

    @Override
    public String tableSize() {
        return deviceMapper.selectTableAmount();
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
    public ChangeResult deleteBatch(List<String> deleteList) {
        return null;
    }

    @Override
    public List<DeviceVo> searchDeviceByDeviceId(String page, String rows, String searchValue) {
        int limit=Integer.parseInt(rows);
        int offset=(Integer.parseInt(page)-1)*limit;
        DeviceVo deviceVo = new DeviceVo();
        deviceVo.setDeviceId(searchValue);
        List<DeviceVo> list=deviceMapper.selectByMultiCondition(limit,offset,deviceVo);
        return list;
    }

    @Override
    public String tableSizeByDeviceId(String searchValue) {
        DeviceVo deviceVo = new DeviceVo();
        deviceVo.setDeviceId(searchValue);
        return deviceMapper.selectTableAmountByMultiCondition(deviceVo);
    }

    @Override
    public List<DeviceVo> searchDeviceByDeviceName(String page, String rows, String searchValue) {
        int limit=Integer.parseInt(rows);
        int offset=(Integer.parseInt(page)-1)*limit;
        DeviceVo deviceVo = new DeviceVo();
        deviceVo.setDeviceName(searchValue);
        List<DeviceVo> list=deviceMapper.selectByMultiCondition(limit,offset,deviceVo);
        return list;
    }

    @Override
    public String tableSizeByDeviceName(String searchValue) {
        DeviceVo deviceVo = new DeviceVo();
        deviceVo.setDeviceName(searchValue);
        return deviceMapper.selectTableAmountByMultiCondition(deviceVo);
    }

    @Override
    public List<DeviceVo> searchDeviceByDeviceTypeName(String page, String rows, String searchValue) {
        int limit=Integer.parseInt(rows);
        int offset=(Integer.parseInt(page)-1)*limit;
        DeviceVo deviceVo = new DeviceVo();
        deviceVo.setDeviceTypeName(searchValue);
        List<DeviceVo> list=deviceMapper.selectByMultiCondition(limit,offset,deviceVo);
        return list;
    }

    @Override
    public String tableSizeByDeviceTypeName(String searchValue) {
        DeviceVo deviceVo = new DeviceVo();
        deviceVo.setDeviceTypeName(searchValue);
        return deviceMapper.selectTableAmountByMultiCondition(deviceVo);
    }


    @Override
    public ChangeResult update(Device device) {
        ChangeResult changeResult = new ChangeResult("200", "OK", null);
        deviceMapper.updateByPrimaryKey(device);
        return changeResult;
    }

    @Override
    public List<Device> getIdMappingName() {
        return deviceMapper.getIdMappingName();
    }

    @Override
    public ChangeResult insert(Device device) {
        List<Device> getIdMappingName = deviceMapper.getIdMappingName();
        ChangeResult changeResult = new ChangeResult("200", "OK", null);
        String status="200";
        for(int i=0;i<getIdMappingName.size();i++){
            Device device1 = getIdMappingName.get(i);
            if(device1.getDeviceId().equals(device1.getDeviceId())){
                status="0";
                changeResult.setStatus(status);
                changeResult.setMsg("设备例检编号已存在，请更换");
                break;
            }
        }
        if(status.equals("200")){
            deviceMapper.insert(device);
        }
        return changeResult;
    }


}
