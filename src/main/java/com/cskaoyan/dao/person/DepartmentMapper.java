package com.cskaoyan.dao.person;

import com.cskaoyan.domain.person.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department>  selectByPrimaryKey(String departmentId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> selectDepartmentList(@Param("limit") int limit, @Param("offset") int offset);
    String count();

    List<Department>  selectBydepartmentName(@Param("departmentName") String departmentName);
}