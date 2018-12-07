package com.cskaoyan.domain.person;

import javax.validation.constraints.NotNull;

public class Department {
    @NotNull(message = "该输入项为必填项")
    private String departmentId;
    @NotNull(message = "该输入项为必填项")
    private String departmentName;
    @NotNull(message = "该输入项为必填项")
    private String note;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}