package com.yc.spirngboot.takeout.bean;

public class Allotinf {
    private Integer id;

    private Integer discrictId;

    private String rename;

    private String rephone;

    private Integer uId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiscrictId() {
        return discrictId;
    }

    public void setDiscrictId(Integer discrictId) {
        this.discrictId = discrictId;
    }

    public String getRename() {
        return rename;
    }

    public void setRename(String rename) {
        this.rename = rename == null ? null : rename.trim();
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
}