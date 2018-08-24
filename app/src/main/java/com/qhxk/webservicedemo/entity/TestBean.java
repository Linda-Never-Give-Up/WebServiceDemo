package com.qhxk.webservicedemo.entity;

import java.io.Serializable;

/**
 * 创建者     WLD
 * 创建时间   2018/8/15 10:23
 * 描述	     测试的实体类
 * 更新描述
 */
public class TestBean implements Serializable {

    private String user;
    private String password;
    private String role;
    private String wsCode;
    private String companyCode;
    private String recordType;
    private String areaCode;
    private String certificateType;
    private String certificateNo;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getWsCode() {
        return wsCode;
    }

    public void setWsCode(String wsCode) {
        this.wsCode = wsCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", wsCode='" + wsCode + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", recordType='" + recordType + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", certificateType='" + certificateType + '\'' +
                ", certificateNo='" + certificateNo + '\'' +
                '}';
    }
}
