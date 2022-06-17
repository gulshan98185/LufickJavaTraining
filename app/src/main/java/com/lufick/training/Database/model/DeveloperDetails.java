package com.lufick.training.Database.model;

public class DeveloperDetails {
    private int dev_id;
    private String dev_name;
    private String dev_skill;
    private int dev_exp;
    private String phoneNo;
    private String mislaneous;

    public String getMislaneous() {
        return mislaneous;
    }

    public void setMislaneous(String mislaneous) {
        this.mislaneous = mislaneous;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getDev_id() {
        return dev_id;
    }

    public void setDev_id(int dev_id) {
        this.dev_id = dev_id;
    }

    public String getDev_name() {
        return dev_name;
    }

    public void setDev_name(String dev_name) {
        this.dev_name = dev_name;
    }

    public String getDev_skill() {
        return dev_skill;
    }

    public void setDev_skill(String dev_skill) {
        this.dev_skill = dev_skill;
    }

    public int getDev_exp() {
        return dev_exp;
    }

    public void setDev_exp(int dev_exp) {
        this.dev_exp = dev_exp;
    }
}
