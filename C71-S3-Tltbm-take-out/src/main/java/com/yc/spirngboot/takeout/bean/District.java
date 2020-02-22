package com.yc.spirngboot.takeout.bean;

public class District {
    private Integer id;

    private Integer cityId;

    private String name;

    private String detailedname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDetailedname() {
        return detailedname;
    }

    public void setDetailedname(String detailedname) {
        this.detailedname = detailedname == null ? null : detailedname.trim();
    }
}