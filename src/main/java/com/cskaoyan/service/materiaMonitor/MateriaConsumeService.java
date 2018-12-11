package com.cskaoyan.service.materiaMonitor;

import com.cskaoyan.domain.materialMonitor.MaterialConsume;
import com.github.pagehelper.PageInfo;

public interface MateriaConsumeService {
    PageInfo<MaterialConsume> findAllMaterialConsume(Integer page, Integer rows);

    boolean insert(MaterialConsume materialConsume);

    boolean update(MaterialConsume materialConsume);

    boolean delectById(String id);

    PageInfo<MaterialConsume> searchConsumeId(String searchValue, Integer page, Integer rows);

    PageInfo<MaterialConsume> serachByWorkId(String searchValue, Integer page, Integer rows);

    PageInfo<MaterialConsume> serachByMaterialId(String searchValue, Integer page, Integer rows);

    boolean updateNote(String consumeId, String note);
}
