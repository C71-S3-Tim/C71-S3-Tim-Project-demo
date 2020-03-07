package com.yc.spirngboot.takeout.bean;

import java.util.Date;

public class Order {
    private Integer id;

    private Integer gId;

    private Integer number;

    private Float money;

    private Integer senderId;

    private Integer sendtime;

    private Date time;

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
}