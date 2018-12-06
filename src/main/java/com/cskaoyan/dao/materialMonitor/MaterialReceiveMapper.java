package com.cskaoyan.dao.materialMonitor;

import com.cskaoyan.domain.materialMonitor.MaterialReceive;

import java.util.List;
import java.util.Map;

public interface MaterialReceiveMapper {
    int deleteByPrimaryKey(String receiveId);

    int insert(MaterialReceive record);

    int insertSelective(MaterialReceive record);

    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByPrimaryKeySelective(MaterialReceive record);

    int updateByPrimaryKey(MaterialReceive record);

    List<MaterialReceive> selectListMaterialReceiver();

    void updateReceiverNote(Map<String, Object> map);

    List<MaterialReceive> searchReceMaterial(String searchValue);

    List<MaterialReceive> searchMaterialId(String searchValue);
}