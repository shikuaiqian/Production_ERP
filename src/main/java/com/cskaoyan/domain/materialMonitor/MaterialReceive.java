package com.cskaoyan.domain.materialMonitor;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.Date;

public class MaterialReceive {
    @Size(min = 8,max = 20,message = "编号要在8-20位之间")
    private String receiveId;
    @Size(min = 8,max = 20,message = "编号要在8-20位之间")
    private String materialId;
    @Max(value = 999999999,message = "数量不合法")
    private Integer amount;
    @DateTimeFormat( pattern = "yyyy-MM-dd")
    private Date receiveDate;
    @Size(min = 2,max = 20,message = "名字要在2-20位之间")
    private String sender;
    @Size(min = 2,max = 20,message = "名字要在2-20位之间")
    private String receiver;
    @Size(max = 200,message = "描述信息要在200字以内")
    private String note;

    private Material material;

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId == null ? null : receiveId.trim();
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}