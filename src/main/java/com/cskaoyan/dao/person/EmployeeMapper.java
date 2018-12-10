package com.cskaoyan.dao.person;

import com.cskaoyan.domain.person.Employee;
import com.cskaoyan.domain.person.EmployeeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    EmployeeVo selectByPrimaryKey(@Param("empId") String empId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);



    List<EmployeeVo> selectEmployeeList(@Param("limit") int limit, @Param("offset") int offset);
    String count();

    List<EmployeeVo> selectEmployeeList2(@Param("map") Map map, @Param("limit")int limit, @Param("offset")int offset);
    String count2(@Param("map") Map map);
    String selectNameById(@Param("id") String id);
    List<EmployeeVo> select();
}