package com.yc.spirngboot.takeout.bean;

public class Allotinf {
    private Integer id;

    private String myrename;

    private String rephone;

    private Integer uId;

    private String addr;

    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMyrename() {
        return myrename;
    }

    public void setMyrename(String myrename) {
        this.myrename = myrename == null ? null : myrename.trim();
    }

    public String getRephone() {
        return rephone;
    }

    public void setRephone(String rephone) {
        this.rephone = rephone == null ? null : rephone.trim();
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}