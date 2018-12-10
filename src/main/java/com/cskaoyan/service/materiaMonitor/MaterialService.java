package com.cskaoyan.service.materiaMonitor;

import com.cskaoyan.domain.materialMonitor.Material;
import com.cskaoyan.domain.materialMonitor.MaterialConsume;
import com.cskaoyan.domain.materialMonitor.MaterialReceive;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface MaterialService {

    List<Material> findAllMaterial();

    boolean insert(Material material);

    boolean update(Material material);

    boolean delectById(String id);

    Material serachById(String id);

    List<Material> searchByType(String searchValue);


    List<Material> serachMaterialsById(String searchValue);

    boolean updateNote(String receiveId, String note);

    PageInfo<Material> findAllMaterial(Integer page, Integer rows);

}
