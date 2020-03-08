package com.yc.spirngboot.takeout.bean;

import java.sql.Timestamp;

public class Comment {
    private Integer id;

    private Integer uId;

    private Integer sId;

    private Timestamp createtime;

    private String content;
    
    
    //一对一电话
    private User user;

   

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	@Override
	public String toString() {
		return "Comment [id=" + id + ", uId=" + uId + ", sId=" + sId + ", createtime=" + createtime + ", content="
				+ content + "]";
	}
    
}