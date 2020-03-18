package com.yc.spirngboot.takeout.web;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yc.spirngboot.takeout.bean.Collect;
import com.yc.spirngboot.takeout.bean.CollectExample;
import com.yc.spirngboot.takeout.bean.District;
import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.bean.SellerExample;
import com.yc.spirngboot.takeout.biz.SellerBiz;
import com.yc.spirngboot.takeout.dao.CollectMapper;

import com.yc.spirngboot.takeout.dao.DistrictMapper;
import com.yc.spirngboot.takeout.dao.SellerMapper;




@Controller
public class SellerAction {
	

	@Resource
	 private SellerMapper sm;
	@Resource
	private DistrictMapper dm;
	@Resource
	private  CollectMapper ce;

	@Resource
	private SellerBiz sbiz;
	
	@GetMapping("shop_intro")
	public String shop_intro(Model m,Integer seller_id,HttpSession hs)  {

		Seller sellers=sbiz.selectById(seller_id);
		System.out.println("11111="+sellers);
		//将数组转成jsong
		 ObjectMapper mapper = new ObjectMapper();
		try {
			String json2=mapper.writeValueAsString(sellers);
			m.addAttribute("seller1", json2);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		m.addAttribute("sellers", sellers);



		int ran = (int) (Math.random() * (70- 30 + 1)) + 30;
		m.addAttribute("ran", ran);
		System.out.println("   =========="+m);
		SellerExample se= new SellerExample();
		
		Seller seller =sm.selectByPrimaryKey(seller_id);
		District district=seller.getDistrict();
		System.out.println(district.getDname());
		m.addAttribute("seller",seller);

		System.out.println(seller_id);
		return "shop_intro";
		

	}
	
	
	@GetMapping("member_collect")
	public String member_collect(Model m, Integer id,Integer u_id) {
		Collect co =new Collect();
		co.setsId(id);
		co.setuId(u_id);
		Collect collect=ce.selectByPrimaryKey(id);
		if(collect ==null) {
			Integer ad = ce.insert(co);
			//根据商家主键和用户主键来获取到收藏页面的只值
			if(ad>1) {
				return "member_collect"; //ajax结果集
			}
		}
		
		return "member_collect";
		
		
	}


	
}
