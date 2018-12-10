package com.cskaoyan.service.materiaMonitor;

import com.cskaoyan.domain.materialMonitor.Material;
import com.cskaoyan.domain.materialMonitor.MaterialReceive;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialReceiveService {
    List<MaterialReceive> findAllMaterialReceive();

    Material getMaterialById(String materialId);

    boolean insert(MaterialReceive materialReceive);

    boolean update(MaterialReceive materialReceive);

    boolean delectById(String id);

    List<MaterialReceive> searchByReceiveId(String searchValue);

    List<MaterialReceive> serachByMaterialId(String searchValue);

    boolean updateNote(@Param("receiveId") String receiveId, @Param("note") String note);
}
