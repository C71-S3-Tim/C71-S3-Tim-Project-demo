package com.yc.spirngboot.takeout.bean;
//order页面类似优惠券的类
public class orderCoupon {
	private int id;
	//名字
	private String name;
	//价值
	private int price;
	//价格
	private int quantity;
	//总价
	private int total_price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	@Override
	public String toString() {
		return "orderCoupon [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", total_price=" + total_price + "]";
	}

	
}
