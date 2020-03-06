package com.yc.spirngboot.takeout.bean;
import javax.validation.constraints.NotEmpty;


import org.hibernate.validator.constraints.Length;

public class User {
    private Integer id;

    @NotEmpty(message="密码不能为空")
    @Length(min=6, message="密码不得低于6位")

    private String pwd;

    private Integer cityId;

    @NotEmpty(message="手机号码不能为空")
    @Length(min=11, max=11, message="请输入11位手机号码")
    private String phone;

    private String uname;

    private Integer sex;

    private Integer cId;

    private Integer integral;

    private String email;

    private Integer vip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }
}