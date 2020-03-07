package com.yc.spirngboot.takeout.vo;

import java.util.Arrays;

public class mercharnt {

	private int id;
	private String description;
	
	private items[] menu_items;

	private boolean recommended;
	//起送费
	private String sendprice;
	

	public String getSendprice() {
		return sendprice;
	}

	public void setSendprice(String sendprice) {
		this.sendprice = sendprice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public items[] getMenu_items() {
		return menu_items;
	}

	public void setMenu_items(items[] menu_items) {
		this.menu_items = menu_items;
	}

	public boolean isRecommended() {
		return recommended;
	}

	public void setRecommended(boolean recommended) {
		this.recommended = recommended;
	}

	@Override
	public String toString() {
		return "mercharnt [id=" + id + ", descriptionl=" + description + ", menu_items=" + Arrays.toString(menu_items)
				+ ", recommended=" + recommended + "]";
	}
	
}
