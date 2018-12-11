package com.cskaoyan.service.materiaMonitor.Imp;

import com.cskaoyan.dao.materialMonitor.MaterialConsumeMapper;
import com.cskaoyan.dao.materialMonitor.MaterialMapper;
import com.cskaoyan.domain.materialMonitor.MaterialConsume;
import com.cskaoyan.service.materiaMonitor.MateriaConsumeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaConsumeServiceImp implements MateriaConsumeService {

    @Autowired
    MaterialConsumeMapper consumeMapper;

    @Autowired
    MaterialMapper materialMapper;

    @Override
    public PageInfo<MaterialConsume> findAllMaterialConsume(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<MaterialConsume> consumes = consumeMapper.findAllMaterialConsume();
        PageInfo<MaterialConsume> pageInfo = new PageInfo<>(consumes);
        return pageInfo;
    }

    @Override
    public boolean insert(MaterialConsume materialConsume) {
        int insert = consumeMapper.insert(materialConsume);
        if (insert == 1) {
            materialMapper.decreaseRemanining(materialConsume.getMaterialId(), materialConsume.getConsumeAmount());
        }
        return insert == 1;
    }

    @Override
    public boolean update(MaterialConsume materialConsume) {
        //拿到之前的amount
        MaterialConsume consume = consumeMapper.selectByPrimaryKey(materialConsume.getConsumeId());
        Integer amount = consume.getConsumeAmount();
        int finalNum = materialConsume.getConsumeAmount() - amount;
        materialMapper.updateRemaining2(materialConsume.getMaterialId(), finalNum);

        int update = consumeMapper.updateByPrimaryKeySelective(materialConsume);

        return update == 1;
    }

    @Override
    public boolean delectById(String id) {
        //删除之前拿到amount
        MaterialConsume consume = consumeMapper.selectByPrimaryKey(id);
        Integer consumeAmount = consume.getConsumeAmount();
        String materialId = consume.getMaterialId();
        materialMapper.increaseRemanining(materialId, consumeAmount);

        int delete = consumeMapper.deleteByPrimaryKey(id);
        return delete == 1;
    }

    @Override
    public PageInfo<MaterialConsume> searchConsumeId(String searchValue,Integer page,Integer rows) {
        searchValue = "%" + searchValue + "%";
        PageHelper.startPage(page,rows);
        List<MaterialConsume> materialConsumes = consumeMapper.selectByConsumeId(searchValue);
        PageInfo<MaterialConsume> pageInfo = new PageInfo<>(materialConsumes);
        return pageInfo;
    }

    @Override
    public PageInfo<MaterialConsume> serachByWorkId(String searchValue,Integer page,Integer rows) {
        searchValue = "%" + searchValue + "%";
        PageHelper.startPage(page,rows);
        List<MaterialConsume> materialConsumes = consumeMapper.selectByWorkId(searchValue);
        PageInfo<MaterialConsume> pageInfo = new PageInfo<>(materialConsumes);
        return pageInfo;
    }

    @Override
    public PageInfo<MaterialConsume> serachByMaterialId(String searchValue,Integer page,Integer rows) {
        searchValue = "%" + searchValue + "%";
        PageHelper.startPage(page,rows);
        List<MaterialConsume> materialConsumes = consumeMapper.selectByMaterialId(searchValue);
        PageInfo<MaterialConsume> pageInfo = new PageInfo<>(materialConsumes);
        return pageInfo;
    }

    @Override
    public boolean updateNote(String consumeId, String note) {
        int update = consumeMapper.updateNote(consumeId, note);
        return update == 1;
    }

}
