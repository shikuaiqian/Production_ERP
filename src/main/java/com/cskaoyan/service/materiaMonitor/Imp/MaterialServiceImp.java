package com.cskaoyan.service.materiaMonitor.Imp;


import com.cskaoyan.dao.materialMonitor.MaterialConsumeMapper;
import com.cskaoyan.dao.materialMonitor.MaterialMapper;
import com.cskaoyan.dao.materialMonitor.MaterialReceiveMapper;
import com.cskaoyan.domain.materialMonitor.Material;
import com.cskaoyan.domain.materialMonitor.MaterialConsume;
import com.cskaoyan.domain.materialMonitor.MaterialReceive;
import com.cskaoyan.service.materiaMonitor.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImp implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;

    @Autowired
    MaterialConsumeMapper materialConsumeMapper;

    @Autowired
    MaterialReceiveMapper materialReceiveMapper;


    @Override
    public List<Material> selectMeterials() {
        return null;
    }

    @Override
    public List<MaterialConsume> materialConsumeList() {
        return null;
    }

    @Override
    public List<MaterialReceive> selectListMaterialRecive() {
        return null;
    }

    @Override
    public void insertMaterial(Material material) {

    }

    @Override
    public void updateMaterial(Material material) {

    }

    @Override
    public List<Material> selectMeterialsByMaterialId(String searchValue) {
        return null;
    }

    @Override
    public List<Material> selectMeterialsBymaterialType(String searchValue) {
        return null;
    }

    @Override
    public void deleteBench(String[] ids) {

    }

    @Override
    public Material selectSingleMaterial(String materialId) {
        return null;
    }

    @Override
    public void addMaterialReceiver(MaterialReceive materialReceive) {

    }

    @Override
    public void updateMaterialNote(String materialId, String note) {

    }

    @Override
    public void updateMaterialReceiveNote(String receiveId, String note) {

    }

    @Override
    public void updateReceMaterial(MaterialReceive materialReceive) {

    }

    @Override
    public void deleteReceBench(String[] ids) {

    }

    @Override
    public List<MaterialReceive> searchByReceId(String searchValue) {
        return null;
    }

    @Override
    public List<MaterialReceive> searchByMaterialID(String searchValue) {
        return null;
    }

    @Override
    public void updateMaterialConsumeNote(String consumeId, String note) {

    }

    @Override
    public void insertMaterialConsume(MaterialConsume materialConsume) {

    }

    @Override
    public void updateMaterialConsume(MaterialConsume materialConsume) {

    }

    @Override
    public void deleteConsumeBench(String[] ids) {

    }

    @Override
    public List<MaterialConsume> searchByConsumeID(String searchValue) {
        return null;
    }

    @Override
    public List<MaterialConsume> searchByWorkID(String searchValue) {
        return null;
    }

    @Override
    public List<MaterialConsume> searchByMarerialID(String searchValue) {
        return null;
    }
}
