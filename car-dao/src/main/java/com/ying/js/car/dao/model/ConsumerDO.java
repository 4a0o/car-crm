package com.ying.js.car.dao.model;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: chengjing
 * Date: 17/11/13
 * Time: 下午5:34
 * CopyRight: taobao
 * Descrption:
 */

public class ConsumerDO {

    private Long id;
    private String name;
    private String phone;
    private String address;
    private Integer carType;
    private String carLicenseNum;
    private String carFrameNum;
    private String content;
    private Date gmtCreate;
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCarType() {
        return carType;
    }

    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    public String getCarLicenseNum() {
        return carLicenseNum;
    }

    public void setCarLicenseNum(String carLicenseNum) {
        this.carLicenseNum = carLicenseNum;
    }

    public String getCarFrameNum() {
        return carFrameNum;
    }

    public void setCarFrameNum(String carFrameNum) {
        this.carFrameNum = carFrameNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
