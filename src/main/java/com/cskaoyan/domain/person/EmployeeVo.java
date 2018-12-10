package com.cskaoyan.domain.person;

public class EmployeeVo extends Employee {
    //这个写类还是String类型，抓包看preview，看他需要一个对象还是一个对象里面的属性。
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
