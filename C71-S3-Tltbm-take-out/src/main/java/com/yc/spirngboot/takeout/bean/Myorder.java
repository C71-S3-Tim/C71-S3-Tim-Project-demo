package com.yc.spirngboot.takeout.bean;

import java.util.Date;

public class Myorder {
    private Integer id;

    private Integer gId;

    private Integer number;

    private Float money;

    private Integer senderId;

    private Integer sendtime;

    private Date time;

    private String ordercode;

    //一对一关联查寻
    private Good mygood;
    
    

	public Good getMygood() {
		return mygood;
	}

	public void setMygood(Good mygood) {
		this.mygood = mygood;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getSendtime() {
        return sendtime;
    }

    public void setSendtime(Integer sendtime) {
        this.sendtime = sendtime;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode == null ? null : ordercode.trim();
    }

	@Override
	public String toString() {
		return "Myorder [id=" + id + ", gId=" + gId + ", number=" + number + ", money=" + money + ", senderId="
				+ senderId + ", sendtime=" + sendtime + ", time=" + time + ", ordercode=" + ordercode + "]";
	}
    
}