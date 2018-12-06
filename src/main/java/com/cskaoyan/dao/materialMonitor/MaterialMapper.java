package com.cskaoyan.dao.materialMonitor;

import com.cskaoyan.domain.materialMonitor.Material;


import java.util.List;
import java.util.Map;

public interface MaterialMapper {
    int deleteByPrimaryKey(String materialId);

    int insert(Material record);

    int insertSelective(Material record);

    Material selectByPrimaryKey(String materialId);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);

    List<Material> selectListMaterial();


    List<Material> selectByMaterialId(String searchValue);

    List<Material> selectByMaterialType(String searchValue);

    void updateNoteById(Map<String, String> map);
}