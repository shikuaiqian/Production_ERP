package com.cskaoyan.service.materiaMonitor;

import com.cskaoyan.domain.materialMonitor.Material;
import com.cskaoyan.domain.materialMonitor.MaterialConsume;
import com.cskaoyan.domain.materialMonitor.MaterialReceive;

import java.util.List;
import java.util.Map;

public interface MaterialService {




    /**
     * @return 返回所有的Material的信息 存放在list中
     */
    List<Material> selectMeterials();

    /**
     * @return 返回所有的MaterialConsume的信息 存放在list中
     */
    List<MaterialConsume> materialConsumeList();

    /**
     * @return 返回所有的MaterialReceive的信息 存放在list中
     */
    List<MaterialReceive> selectListMaterialRecive();

    /**
     * @param material 将一个Material的对象存放在数据库中
     */
    void insertMaterial(Material material);

    /**
     * @param material  根据Material的MaterialID更新对应的material 调用时请注意sql语句
     */
    void updateMaterial(Material material);

    /**
     * @param searchValue searchValue是MaterialId进行的模糊查询
     * @return
     */
    List<Material> selectMeterialsByMaterialId(String searchValue);

    /**
     * @param searchValue 是MaterialType的数据 然后根据这个进行模糊查询
     * @return
     */
    List<Material> selectMeterialsBymaterialType(String searchValue);

    /**
     * @param ids 是一个MaterialID的数组 并根据MaterialId进行模糊查询
     */
    void deleteBench(String[] ids);

    /**
     * @param materialId 查询用的参数
     * @return  返回单个的Material
     */
    Material selectSingleMaterial(String materialId);

    /**
     * @param materialReceive 向数据库中添加MaterialReceiver信息
     *                       同时修改其中相应Material的数量
     */
    void addMaterialReceiver(MaterialReceive materialReceive);

    /**
     * @param materialId 识别唯一的material然后修改其中的note
     * @param note  要更新的备注
     */
    void updateMaterialNote(String materialId, String note);

    /**
     * @param receiveId 根据receiveId修改MaterId的Note
     * @param note  需要修改的Note的值
     */
    void updateMaterialReceiveNote(String receiveId, String note);

    /**
     * @param materialReceive 更新 MaterialReceive 根据receiveId 不修改receiveId
     */
    void updateReceMaterial(MaterialReceive materialReceive);

    /**
     * @param ids 根据receiveId的数组进行批量删除MaterialReceive
     */
    void deleteReceBench(String[] ids);

    /**
     * @param searchValue 根据ReceId进行模糊查询
     * @return 返回一个MaterialReceive的集合
     */
    List<MaterialReceive> searchByReceId(String searchValue);

    /**
     * @param searchValue 模糊查询ByMaterialID
     * @return  返回一个集合
     */
    List<MaterialReceive> searchByMaterialID(String searchValue);

    /**
     * @param consumeId  根据consumeId修改其note的值
     * @param note
     */
    void updateMaterialConsumeNote(String consumeId, String note);

    /**
     * @param materialConsume 项数据库中插入一个materialConsume
     */
    void insertMaterialConsume(MaterialConsume materialConsume);

    /**
     * @param materialConsume materialConsumeId修改其的值
     */
    void updateMaterialConsume(MaterialConsume materialConsume);

    /**
     * @param ids 批量删除ConsumeId的MaterialConsume
     */
    void deleteConsumeBench(String[] ids);

    /**
     * @param searchValue 根据searchValue进行模糊查询
     * @return     返回一个list集合
     */
    List<MaterialConsume> searchByConsumeID(String searchValue);

    List<MaterialConsume> searchByWorkID(String searchValue);

    List<MaterialConsume> searchByMarerialID(String searchValue);
}
