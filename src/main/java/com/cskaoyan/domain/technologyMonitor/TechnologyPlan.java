package com.cskaoyan.domain.technologyMonitor;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TechnologyPlan {
    private String technologyName;

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    private String technologyPlanId;

    private String technologyId;

    private Integer batchAmount;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startPlan;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endPlan;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date commitPlan;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date technologyPlanStart;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date technologyPlanEnd;

    public String getTechnologyPlanId() {
        return technologyPlanId;
    }

    public void setTechnologyPlanId(String technologyPlanId) {
        this.technologyPlanId = technologyPlanId == null ? null : technologyPlanId.trim();
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId == null ? null : technologyId.trim();
    }

    public Integer getBatchAmount() {
        return batchAmount;
    }

    public void setBatchAmount(Integer batchAmount) {
        this.batchAmount = batchAmount;
    }

    public Date getStartPlan() {
        return startPlan;
    }

    public void setStartPlan(Date startPlan) {
        this.startPlan = startPlan;
    }

    public Date getEndPlan() {
        return endPlan;
    }

    public void setEndPlan(Date endPlan) {
        this.endPlan = endPlan;
    }

    public Date getCommitPlan() {
        return commitPlan;
    }

    public void setCommitPlan(Date commitPlan) {
        this.commitPlan = commitPlan;
    }

    public Date getTechnologyPlanStart() {
        return technologyPlanStart;
    }

    public void setTechnologyPlanStart(Date technologyPlanStart) {
        this.technologyPlanStart = technologyPlanStart;
    }

    public Date getTechnologyPlanEnd() {
        return technologyPlanEnd;
    }

    public void setTechnologyPlanEnd(Date technologyPlanEnd) {
        this.technologyPlanEnd = technologyPlanEnd;
    }
}