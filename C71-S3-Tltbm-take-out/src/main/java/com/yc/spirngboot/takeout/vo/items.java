package com.yc.spirngboot.takeout.vo;

import java.util.Arrays;

public class items {
	private int id;
	private Float price;
	private boolean is_valid;
	private boolean visible;
	private int sectionId;
	private int position;
	private int ordercount;
	private Object[] Optionsets;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public boolean isIs_valid() {
		return is_valid;
	}
	public void setIs_valid(boolean is_valid) {
		this.is_valid = is_valid;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getOrdercount() {
		return ordercount;
	}
	public void setOrdercount(int ordercount) {
		this.ordercount = ordercount;
	}
	public Object[] getOptionsets() {
		return Optionsets;
	}
	public void setOptionsets(Object[] optionsets) {
		Optionsets = optionsets;
	}
	@Override
	public String toString() {
		return "items [id=" + id + ", price=" + price + ", is_valid=" + is_valid + ", visible=" + visible
				+ ", sectionId=" + sectionId + ", position=" + position + ", ordercount=" + ordercount + ", Optionsets="
				+ Arrays.toString(Optionsets) + "]";
	}
	
	

	
	

}
