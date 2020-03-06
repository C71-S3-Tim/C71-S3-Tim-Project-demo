package com.yc.spirngboot.takeout.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yc.spirngboot.takeout.bean.Good;
import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.dao.SellerMapper;
import com.yc.spirngboot.takeout.vo.items;
import com.yc.spirngboot.takeout.vo.mercharnt;

@Controller
public class SellerShowAction {
	private int id;
	@Resource
	private SellerMapper sm;
	//店铺菜品展示 
	@GetMapping("show")
	public String show(Model m,int sellerId ,HttpSession hs) {
		Seller seller=sm.selectByPrimaryKey(sellerId);
		m.addAttribute("seller", seller);
		System.out.println("================="+seller.getId());
		//数据测试
		//构建推送到前端的商品的数据结构和数据
		items [] menu_items=new items[seller.getGoods().size()] ;
		for(int i=0;i<seller.getGoods().size();i++) {
			items item=new items();
			Good g=seller.getGoods().get(i);
			item.setId(g.getId());
			item.setPrice(seller.getGoods().get(i).getPrice());
			item.setIs_valid(true);
			item.setVisible(true);
			item.setSectionId(39215);
			item.setPosition(0);
			item.setOrdercount(8);
			
			item.setOptionsets(new Object[0]);
			menu_items[i]=item;
		}
		
		
		mercharnt mch=new mercharnt();
		mch.setId(39215);
		mch.setDescription("描述测试");
		mch.setMenu_items(menu_items);
		mch.setRecommended(false);
		//加入起送费
		mch.setSendprice(seller.getSendprice()+"");
		
		
		
		
		//将商家数据转成json 
        ObjectMapper mapper = new ObjectMapper();
        try {
        	
        	String json2=mapper.writeValueAsString(mch);
        	System.out.println("json"+json2);
        	m.addAttribute("sellerinfo",json2);
        	
        	
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		id=sellerId;
		return "shop_detail";
	}
	//ajax传入对象到页面
	@PostMapping("req")
	@ResponseBody()
	public Seller requst() {
		Seller seller=sm.selectByPrimaryKey(id);
		return seller;
		
	}
}
