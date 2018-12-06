package com.cskaoyan.service.materiaMonitor.Imp;

import com.cskaoyan.domain.materialMonitor.Material;
import com.cskaoyan.domain.materialMonitor.MaterialConsume;
import com.cskaoyan.domain.materialMonitor.MaterialReceive;
import com.cskaoyan.dao.materialMonitor.MaterialConsumeMapper;
import com.cskaoyan.dao.materialMonitor.MaterialMapper;
import com.cskaoyan.dao.materialMonitor.MaterialReceiveMapper;
import com.cskaoyan.service.materiaMonitor.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;

    @Autowired
    MaterialConsumeMapper materialConsumeMapper;

    @Autowired
    MaterialReceiveMapper materialReceiveMapper;

    /**
     * 获取所有的Material信息 并存放在集合list中
     */
    @Override
    public List<Material> selectMeterials() {
        //ton
        List<Material> materialList = materialMapper.selectListMaterial();
        return materialList;
    }

    /**
     * 获取所有的MaterialConsume信息 并存放在集合list中
     */
    @Override
    public List<MaterialConsume> materialConsumeList() {

        List<MaterialConsume> materialConsumesList = materialConsumeMapper.selectListMaterialConsume();

        return materialConsumesList;
    }

    /**
     * 获取所有的MaterialReceive信息 并存放在集合list中
     */
    @Override
    public List<MaterialReceive> selectListMaterialRecive() {

        List<MaterialReceive> materialReceiveList = materialReceiveMapper.selectListMaterialReceiver();

        return materialReceiveList;
    }

    /**
     * 将单个的Material的信息插入到数据库中
     */
    @Override
    public void insertMaterial(Material material) {
        materialMapper.insert(material);
    }


    /**
     * 根据单个Material的MaterialId将数据更新
     */
    @Override
    public void updateMaterial(Material material) {
        int i = materialMapper.updateByPrimaryKeySelective(material);
        //判断是否修改成功
        System.out.println("update is success " + i);
    }

    /**
     * 模糊查询MaterialId的信息 sql语句中的test测试的是类里的字段 并且有get和set方法
     */
    @Override
    public List<Material> selectMeterialsByMaterialId(String searchValue) {
        List<Material> materialList;
        if (searchValue != null && !searchValue.isEmpty()) {

            materialList = materialMapper.selectByMaterialId(searchValue);

        } else {

            materialList = materialMapper.selectListMaterial();

        }

        return materialList;
    }

    /**
     * 根据MaterialType模糊查询material的物料信息
     */
    @Override
    public List<Material> selectMeterialsBymaterialType(String searchValue) {
        List<Material> materialList;
        if (searchValue != null && !searchValue.isEmpty()) {

            materialList = materialMapper.selectByMaterialType(searchValue);

        } else {

            materialList = materialMapper.selectListMaterial();

        }

        return materialList;

    }

    /**
     * 根据MaterialId的数组 遍历的删除Material
     */
    @Override
    public void deleteBench(String[] ids) {

        for (String id : ids) {

            materialMapper.deleteByPrimaryKey(id);

        }
    }

    /**
     * @param materialId 根据materialId查询到物料
     * @return 返回一个Material的类
     */
    @Override
    public Material selectSingleMaterial(String materialId) {
        Material material = materialMapper.selectByPrimaryKey(materialId);
        return material;
    }

    @Override
    public void addMaterialReceiver(MaterialReceive materialReceive) {

        //首先向数据库中增加receiver的项目
        materialReceiveMapper.insert(materialReceive);

        //获取增加的数量
        Integer amount = materialReceive.getAmount();
        //获取Material的materialId
        String materialId = materialReceive.getMaterialId();
        //根据materialId获取到相应的对象
        Material material = materialMapper.selectByPrimaryKey(materialId);
        //修改相应的Material的剩余的产品的数量
        material.setRemaining(material.getRemaining() + amount);
        materialMapper.updateByPrimaryKey(material);

    }

    /**
     * @param materialId 识别唯一的material然后修改其中的note
     * @param note       要更新的备注
     */
    @Override
    public void updateMaterialNote(String materialId, String note) {
        Map<String, String> map = new HashMap<>();
        map.put("receiveId", materialId);
        map.put("note", note);
        materialMapper.updateNoteById(map);
    }

    /**
     * @param receiveId 根据此参数获取到MaterialReceive的
     * @param note      修改其中的note的值
     */
    @Override
    public void updateMaterialReceiveNote(String receiveId, String note) {
        Map<String, Object> map = new HashMap<>();
        map.put("receiveId", receiveId);
        map.put("note", note);
        materialReceiveMapper.updateReceiverNote(map);
    }

    /**
     * @param materialReceive 需要修改的对象的MaterialRece的信息
     */
    @Override
    public void updateReceMaterial(MaterialReceive materialReceive) {
        int i = materialReceiveMapper.updateByPrimaryKey(materialReceive);
    }

    /**
     * @param ids 需要删除的Material的ReceiverID的信息
     */
    @Override
    public void deleteReceBench(String[] ids) {
        for (String id : ids) {
            materialReceiveMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<MaterialReceive> searchByReceId(String searchValue) {

        List<MaterialReceive> materialList;
        if (searchValue != null && !searchValue.isEmpty()) {

            materialList = materialReceiveMapper.searchReceMaterial(searchValue);

        } else {

            materialList = materialReceiveMapper.selectListMaterialReceiver();

        }

        return materialList;


    }

    @Override
    public List<MaterialReceive> searchByMaterialID(String searchValue) {

        List<MaterialReceive> materialList;
        if (searchValue != null && !searchValue.isEmpty()) {

            materialList = materialReceiveMapper.searchMaterialId(searchValue);

        } else {

            materialList = materialReceiveMapper.selectListMaterialReceiver();

        }

        return materialList;

    }

    @Override
    public void updateMaterialConsumeNote(String consumeId, String note) {
        Map<String,String> map = new HashMap<String,String>();

        map.put("consumeId",consumeId);
        map.put("note",note);

        materialConsumeMapper.updateMaterialConsumeNote(map);

    }

    @Override
    public void insertMaterialConsume(MaterialConsume materialConsume) {

        materialConsumeMapper.insert(materialConsume);

    }

    @Override
    public void updateMaterialConsume(MaterialConsume materialConsume) {
        materialConsumeMapper.updateByPrimaryKey(materialConsume);
    }

    @Override
    public void deleteConsumeBench(String[] ids) {

        for (String id : ids) {
            materialConsumeMapper.deleteByPrimaryKey(id);
        }

    }

    @Override
    public List<MaterialConsume> searchByConsumeID(String searchValue) {

       return materialConsumeMapper.searchByConsumeId(searchValue);

    }

    @Override
    public List<MaterialConsume> searchByWorkID(String searchValue) {

        return materialConsumeMapper.searchByWorkId(searchValue);
    }

    @Override
    public List<MaterialConsume> searchByMarerialID(String searchValue) {

        return materialConsumeMapper.searchByMaterialId(searchValue);
    }
}
