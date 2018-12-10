package com.cskaoyan.dao.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Manufacture;
import com.cskaoyan.domain.designScheduleDomain.ManufactureVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManufactureMapper {
    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);

    List<ManufactureVo> selectByPage(int offset, int rows, Object o);

    int count(@Param("param3") Object o);

    List<Manufacture> findAll();
}