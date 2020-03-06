package com.yc.spirngboot.takeout.vo;
//order页面的地址展示数据结构

import java.util.ArrayList;
import java.util.List;

import com.yc.spirngboot.takeout.bean.Allotinf;

public class OrderAddr {
	
	private boolean active=false;
	
	private String customer_name;
	//配送地址
	private String delivery_address;
	//电话
	private String customer_phone;
	
	private String id;
	
	private String method;
	private String url;
/**
 * 将list<Allotinfo>  转成List<OrderAddr>
 * @return
 */
	public List<OrderAddr> toOrder(List<Allotinf> allList){
		List<OrderAddr> addrList=new ArrayList<>();
		
		for(Allotinf f:allList) {
			OrderAddr addr=new OrderAddr();
			addr.setCustomer_name(f.getMyrename());
			addr.setCustomer_phone(f.getRephone());
			addr.setId(f.getId()+"");
			addr.setDelivery_address(f.getAddr());
			addrList.add(addr);
			
		}
		return addrList;
		
	}
	
	
	
	public String getMethod() {
	return method;
}



public void setMethod(String method) {
	this.method = method;
}



public String getUrl() {
	return url;
}



public void setUrl(String url) {
	this.url = url;
}



	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}

	public String getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "OrderAddr [active=" + active + ", customer_name=" + customer_name + ", delivery_address="
				+ delivery_address + ", customer_phone=" + customer_phone + ", id=" + id + "]";
	}
	
}
