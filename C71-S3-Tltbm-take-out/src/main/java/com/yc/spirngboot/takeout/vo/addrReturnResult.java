package com.yc.spirngboot.takeout.vo;
/**
 * 用于配合checkout.js中新增地址的时候要用到的地址新增ajax结果集返回对象
 * @author DELL
 *
 */
public class addrReturnResult {
	private String status;
	private String id;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "addrReturnResult [status=" + status + ", id=" + id + "]";
	}
	

}
