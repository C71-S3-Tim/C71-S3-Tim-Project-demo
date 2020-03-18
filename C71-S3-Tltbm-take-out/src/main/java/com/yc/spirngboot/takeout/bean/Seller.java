package com.yc.spirngboot.takeout.bean;

import java.util.List;

public class Seller {
    private Integer id;

    private String sname;

    private Double sendprice;

    private Double packprice;

    private String logimge;

    private Integer starttime;

    private Integer endtime;

    private String sphone;

    private String images;

    private Integer cityId;

    private Integer rank;

    private Integer hot;

    private Integer qualified;

    private String spwd;

    private String description;

    //一对多关联查询商品
    private List<Good> goods;
    
    //一对一关联地区
    private District district;
    //一对一城市
    private City city;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

    
    public List<Good> getGoods() {
		return goods;
	}

	public void setGoods(List<Good> goods) {
		this.goods = goods;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public Double getSendprice() {
        return sendprice;
    }

    public void setSendprice(Double sendprice) {
        this.sendprice = sendprice;
    }

    public Double getPackprice() {
        return packprice;
    }

    public void setPackprice(Double packprice) {
        this.packprice = packprice;
    }

    public String getLogimge() {
        return logimge;
    }

    public void setLogimge(String logimge) {
        this.logimge = logimge == null ? null : logimge.trim();
    }

    public Integer getStarttime() {
        return starttime;
    }

    public void setStarttime(Integer starttime) {
        this.starttime = starttime;
    }

    public Integer getEndtime() {
        return endtime;
    }

    public void setEndtime(Integer endtime) {
        this.endtime = endtime;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone == null ? null : sphone.trim();
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Integer getQualified() {
        return qualified;
    }

    public void setQualified(Integer qualified) {
        this.qualified = qualified;
    }

    public String getSpwd() {
        return spwd;
    }

    public void setSpwd(String spwd) {
        this.spwd = spwd == null ? null : spwd.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}