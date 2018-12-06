package com.cskaoyan.dao.materialMonitor;

import com.cskaoyan.domain.materialMonitor.MaterialConsume;

import java.util.List;
import java.util.Map;

public interface MaterialConsumeMapper {
    int deleteByPrimaryKey(String consumeId);

    int insert(MaterialConsume record);

    int insertSelective(MaterialConsume record);

    MaterialConsume selectByPrimaryKey(String consumeId);

    int updateByPrimaryKeySelective(MaterialConsume record);

    int updateByPrimaryKey(MaterialConsume record);

    List<MaterialConsume> selectListMaterialConsume();

    void updateMaterialConsumeNote(Map<String, String> map);

    List<MaterialConsume> searchByConsumeId(String searchValue);

    List<MaterialConsume> searchByWorkId(String searchValue);

    List<MaterialConsume> searchByMaterialId(String searchValue);
}