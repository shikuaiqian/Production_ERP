package com.cskaoyan.dao.materialMonitor;

import com.cskaoyan.domain.materialMonitor.Material;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MaterialMapper {
    int deleteById(String materialId);

    int insert(Material material);

    int insertSelective(Material record);

    Material selectByPrimaryKey(String materialId);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);

    List<Material> findAllMaterial();

    List<Material> selectByType(String searchValue);

    List<Material> selectByMaterialId(String searchValue);

    int updateNote(String materialId, String note);

    void increaseRemanining(String materialId, Integer amount);

    void decreaseRemanining(String materialId, Integer consumeAmount);

    void updateRemaining(String materialId, int finalNum);

    void updateRemaining2(String materialId, int finalNum);


}