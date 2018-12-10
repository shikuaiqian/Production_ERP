package com.cskaoyan.service.materiaMonitor.Imp;

import com.cskaoyan.dao.materialMonitor.MaterialMapper;
import com.cskaoyan.dao.materialMonitor.MaterialReceiveMapper;
import com.cskaoyan.domain.materialMonitor.Material;
import com.cskaoyan.domain.materialMonitor.MaterialReceive;
import com.cskaoyan.service.materiaMonitor.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MaterialReceiveServiceImp implements MaterialReceiveService {
    @Autowired
    MaterialReceiveMapper receiveMapper;

    @Autowired
    MaterialMapper materialMapper;

    @Override
    public List<MaterialReceive> findAllMaterialReceive() {
        List<MaterialReceive> materialReceives = receiveMapper.findAllMaterialReceive();
        return materialReceives;
    }

    @Override
    public Material getMaterialById(String materialId) {
        Material material = materialMapper.selectByPrimaryKey(materialId);
        return material;
    }

    @Override
    public boolean insert(MaterialReceive materialReceive) {
        int insert = receiveMapper.insert(materialReceive);
        if (insert == 1) {
            materialMapper.increaseRemanining(materialReceive.getMaterialId(), materialReceive.getAmount());
        }
        return insert == 1;
    }

    @Override
    public boolean update(MaterialReceive materialReceive) {
        //拿到之前的amount
        MaterialReceive receive = receiveMapper.selectByPrimaryKey(materialReceive.getReceiveId());
        Integer amount = receive.getAmount();
        int finalNum = materialReceive.getAmount() - amount;
        materialMapper.updateRemaining(materialReceive.getMaterialId(), finalNum);

        int update = receiveMapper.updateByPrimaryKeySelective(materialReceive);

        return update == 1;
    }

    @Override
    public boolean delectById(String id) {
        //删除之前拿到amount
        MaterialReceive receive = receiveMapper.selectByPrimaryKey(id);
        Integer amount = receive.getAmount();
        String materialId = receive.getMaterialId();
        materialMapper.decreaseRemanining(materialId,amount);
//        //拿到剩余数量
//        String materialId = receive.getMaterialId();
//        Material material = materialMapper.selectByPrimaryKey(materialId);
//        material.getRemaining();
        int delete = receiveMapper.deleteByPrimaryKey(id);
        return delete == 1;
    }

    @Override
    public List<MaterialReceive> searchByReceiveId(String searchValue) {
        searchValue = "%" + searchValue + "%";
        List<MaterialReceive> receives = receiveMapper.selectByReceiveId(searchValue);
        return receives;
    }

    @Override
    public List<MaterialReceive> serachByMaterialId(String searchValue) {
        searchValue = "%" + searchValue + "%";
        List<MaterialReceive> receives = receiveMapper.selectByMaterialId(searchValue);
        return receives;

    }

    @Override
    public boolean updateNote(String receiveId, String note) {
        int update = receiveMapper.updateNote(receiveId, note);
        return update == 1;
    }
}
