package com.cskaoyan.service.materiaMonitor.Imp;


import com.cskaoyan.dao.materialMonitor.MaterialConsumeMapper;
import com.cskaoyan.dao.materialMonitor.MaterialMapper;
import com.cskaoyan.dao.materialMonitor.MaterialReceiveMapper;
import com.cskaoyan.domain.materialMonitor.Material;
import com.cskaoyan.domain.materialMonitor.MaterialConsume;
import com.cskaoyan.domain.materialMonitor.MaterialReceive;
import com.cskaoyan.service.materiaMonitor.MaterialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaterialServiceImp implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Material> findAllMaterial() {
        List<Material> materials = materialMapper.findAllMaterial();
        return materials;
    }

    @Override
    public PageInfo<Material> findAllMaterial(Integer page,Integer rows) {
        PageHelper.startPage(page,rows);
        List<Material> materials = materialMapper.findAllMaterial();
        PageInfo<Material> pageInfo = new PageInfo<>(materials);
        return pageInfo;
    }

    @Override
    public boolean insert(Material material) {
        int insert = materialMapper.insert(material);
        return insert==1;
    }

    @Override
    public boolean update(Material material) {
        int update = materialMapper.updateByPrimaryKeySelective(material);
        return update==1;
    }

    @Override
    public boolean delectById(String id) {
        int delete = materialMapper.deleteById(id);
        return delete==1;
    }

    @Override
    public Material serachById(String id) {
        Material material = materialMapper.selectByPrimaryKey(id);
        return material;
    }

    @Override
    public List<Material> searchByType(String searchValue) {
        searchValue = "%" + searchValue + "%";
        List<Material> materials = materialMapper.selectByType(searchValue);
        return materials;
    }

    @Override
    public List<Material> serachMaterialsById(String searchValue) {
        searchValue = "%" + searchValue + "%";
        List<Material> materials = materialMapper.selectByMaterialId(searchValue);
        return materials;
    }

    @Override
    public boolean updateNote(String materialId, String note) {
        int update = materialMapper.updateNote(materialId,note);
        return update==1;
    }

}
