package com.cskaoyan.domain.materialMonitor;

import com.cskaoyan.domain.designScheduleDomain.Work;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.Date;

public class MaterialConsume {
    @Size(min = 8,max = 20,message = "编号要在8-20位之间")
    private String consumeId;

    private String workId;

    private String materialId;
    @Max(value = 999999999,message = "数量不合法")
    private Integer consumeAmount;
    @DateTimeFormat( pattern = "yyyy-MM-dd")
    private Date consumeDate;
    @Size(min = 2,max = 20,message = "名字要在2-20位之间")
    private String sender;
    @Size(min = 2,max = 20,message = "名字要在2-20位之间")
    private String receiver;
    @Size(max = 200,message = "描述信息要在200字以内")
    private String note;

    private Work work;

    private Material material;

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getConsumeId() {
        return consumeId;
    }

    public void setConsumeId(String consumeId) {
        this.consumeId = consumeId == null ? null : consumeId.trim();
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public Integer getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(Integer consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public Date getConsumeDate() {
        return consumeDate;
    }

    public void setConsumeDate(Date consumeDate) {
        this.consumeDate = consumeDate;
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