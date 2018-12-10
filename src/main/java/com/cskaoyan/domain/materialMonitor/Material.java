package com.cskaoyan.domain.materialMonitor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class Material {
    @Size(min = 8,max = 20,message = "编号要在8-20位之间")
    private String materialId;
    @Size(min = 2,max = 8,message = "类型要在2-8位之间")
    private String materialType;

    private String status;
    @Max(value = 999999999,message = "数量不合法")
    private Integer remaining;
    @Size(max = 200,message = "描述信息要在200字以内")
    private String note;

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType == null ? null : materialType.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}