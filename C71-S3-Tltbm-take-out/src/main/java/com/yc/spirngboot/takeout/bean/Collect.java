package com.yc.spirngboot.takeout.bean;

import java.util.List;

public class Collect {
    private Integer id;

    private Integer uId;

    private Integer sId;
    //一对一的关联查询
    private Seller sellers;

	public Seller getSellers() {
		return sellers;
	}

	public void setSellers(Seller sellers) {
		this.sellers = sellers;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
    	
        this.sId = sId;
    }

	@Override
	public String toString() {
		return "Collect [id=" + id + ", uId=" + uId + ", sId=" + sId + ", sellers=" + sellers + "]";
	}
    
}