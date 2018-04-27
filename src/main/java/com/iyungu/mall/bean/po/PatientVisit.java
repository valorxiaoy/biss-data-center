package com.iyungu.mall.bean.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class PatientVisit {

    private Long id;

    private String processedId;

    private String applicantName;

    private String applicantDepartment;

    private String applicantBednum;

    private Date createTime;

    private Integer visitStatus;

    private Long operUserId;

    private Date operTime;

    private String operRemark;

    private Date visitBeginTime;

    private Date visitEndTime;

    private Integer visitDuration;

    private Date inHospitalTime;

    /**
     * 当前时间
     */
    private Date currentTime;

    private String idCard;

    private String uuid;

    private String receiveUserBednums;

    private List<Long> visitStatusList;

    private String receiveUseDeviceIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcessedId() {
        return processedId;
    }

    public void setProcessedId(String processedId) {
        this.processedId = processedId == null ? null : processedId.trim();
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName == null ? null : applicantName.trim();
    }

    public String getApplicantDepartment() {
        return applicantDepartment;
    }

    public void setApplicantDepartment(String applicantDepartment) {
        this.applicantDepartment = applicantDepartment == null ? null : applicantDepartment.trim();
    }

    public String getApplicantBednum() {
        return applicantBednum;
    }

    public void setApplicantBednum(String applicantBednum) {
        this.applicantBednum = applicantBednum == null ? null : applicantBednum.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(Integer visitStatus) {
        this.visitStatus = visitStatus;
    }

    public Long getOperUserId() {
        return operUserId;
    }

    public void setOperUserId(Long operUserId) {
        this.operUserId = operUserId;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public String getOperRemark() {
        return operRemark;
    }

    public void setOperRemark(String operRemark) {
        this.operRemark = operRemark == null ? null : operRemark.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getVisitBeginTime() {
        return visitBeginTime;
    }

    public void setVisitBeginTime(Date visitBeginTime) {
        this.visitBeginTime = visitBeginTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getVisitEndTime() {
        return visitEndTime;
    }

    public void setVisitEndTime(Date visitEndTime) {
        this.visitEndTime = visitEndTime;
    }

    public Integer getVisitDuration() {
        return visitDuration;
    }

    public void setVisitDuration(String visitDuration) {
        this.visitDuration = 0;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getInHospitalTime() {
        return inHospitalTime;
    }

    public void setInHospitalTime(Date inHospitalTime) {
        this.inHospitalTime = inHospitalTime;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getReceiveUserBednums() {
        return receiveUserBednums;
    }

    public void setReceiveUserBednums(String receiveUserBednums) {
        this.receiveUserBednums = receiveUserBednums;
    }

    public void setVisitDuration(Integer visitDuration) {
        this.visitDuration = visitDuration;
    }

    public List<Long> getVisitStatusList() {
        return visitStatusList;
    }

    public void setVisitStatusList(List<Long> visitStatusList) {
        this.visitStatusList = visitStatusList;
    }

    public String getReceiveUseDeviceIds() {
        return receiveUseDeviceIds;
    }

    public void setReceiveUseDeviceIds(String receiveUseDeviceIds) {
        this.receiveUseDeviceIds = receiveUseDeviceIds;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }
}