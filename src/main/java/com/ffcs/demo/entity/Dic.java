package com.ffcs.demo.entity;

import java.util.Date;

public class Dic {
    private Integer dicsId;

    private String dicsCode;

    private String dicsName;

    private String keyValue;

    private String keyName;

    private Date oprDate;

    private Integer oprId;

    public Integer getDicsId() {
        return dicsId;
    }

    public void setDicsId(Integer dicsId) {
        this.dicsId = dicsId;
    }

    public String getDicsCode() {
        return dicsCode;
    }

    public void setDicsCode(String dicsCode) {
        this.dicsCode = dicsCode == null ? null : dicsCode.trim();
    }

    public String getDicsName() {
        return dicsName;
    }

    public void setDicsName(String dicsName) {
        this.dicsName = dicsName == null ? null : dicsName.trim();
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue == null ? null : keyValue.trim();
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName == null ? null : keyName.trim();
    }

    public Date getOprDate() {
        return oprDate;
    }

    public void setOprDate(Date oprDate) {
        this.oprDate = oprDate;
    }

    public Integer getOprId() {
        return oprId;
    }

    public void setOprId(Integer oprId) {
        this.oprId = oprId;
    }
}