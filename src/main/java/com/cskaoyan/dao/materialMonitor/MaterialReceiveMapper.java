package com.cskaoyan.dao.materialMonitor;

import com.cskaoyan.domain.materialMonitor.MaterialReceive;

import java.util.List;

public interface MaterialReceiveMapper {
    int deleteByPrimaryKey(String receiveId);

    int insert(MaterialReceive record);

    int insertSelective(MaterialReceive record);

    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByPrimaryKeySelective(MaterialReceive record);

    int updateByPrimaryKey(MaterialReceive record);

    List<MaterialReceive> findAllMaterialReceive();

    List<MaterialReceive> selectByReceiveId(String searchValue);

    List<MaterialReceive> selectByMaterialId(String searchValue);

    int updateNote(String receiveId, String note);
}