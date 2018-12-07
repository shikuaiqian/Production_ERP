package com.cskaoyan.dao.materialMonitor;

import com.cskaoyan.domain.materialMonitor.Material;

import java.util.List;

public interface MaterialMapper {
    int deleteByPrimaryKey(String materialId);

    int insert(Material record);

    int insertSelective(Material record);

    Material selectByPrimaryKey(String materialId);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);


    List<Material> selectListMaterial();
}