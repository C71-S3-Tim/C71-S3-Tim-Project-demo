package com.yc.spirngboot.takeout.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.yc.spirngboot.takeout.bean.Myorder;
import com.yc.spirngboot.takeout.bean.orderCoupon;

//用户order页面数据的类
public class orderIteam {
	
	private int id;
	//选购的上商品名
	private String name;
	//价格
	private float price;
	//数量
	private int quantity;
	//类似优惠券
	private orderCoupon[] additions;
	//???
	private Object[] options;
	
	/**
	 * 将list<Allotinfo>  转成List<OrderAddr>
	 * @return
	 */
		public List<orderIteam> toOrder(List<Myorder> myorderList){
			List<orderIteam> orderList=new ArrayList<>();
			
			for(Myorder f:myorderList) {
				orderIteam oitem=new orderIteam();
				oitem.setId(f.getId()/2+2236070);
				oitem.setName(f.getMygood().getGname());
				oitem.setPrice(f.getMoney());
				oitem.setQuantity(f.getNumber());
				orderList.add(oitem);
			}
			return orderList;
			
		}
	
	
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public orderCoupon[] getAdditions() {
		return additions;
	}
	public void setAdditions(orderCoupon[] additions) {
		this.additions = additions;
	}
	public Object[] getOptions() {
		return options;
	}
	public void setOptions(Object[] options) {
		this.options = options;
	}
	@Override
	public String toString() {
		return "orderIteam [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", additions=" + Arrays.toString(additions) + ", options=" + Arrays.toString(options) + "]";
	}
	
	

}
