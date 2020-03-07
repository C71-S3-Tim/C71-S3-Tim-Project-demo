package com.yc.spirngboot.takeout.vo;

public class Result {
	//返回的结果码 正确是1 错误是0
	private int code;
	//返回的消息
	private String msg;
	//返回的数据
	private Object data;
	
	
	public Result() {
		super();
	}
	public Result(int code) {
		super();
		this.code = code;
	}
	public Result(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public Result(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	

}
