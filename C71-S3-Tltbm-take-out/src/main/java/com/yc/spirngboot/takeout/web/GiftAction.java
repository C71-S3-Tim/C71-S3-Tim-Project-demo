package com.yc.spirngboot.takeout.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.spirngboot.takeout.bean.Allotinf;
import com.yc.spirngboot.takeout.bean.Gift;
import com.yc.spirngboot.takeout.biz.GiftsBiz;
import com.yc.spirngboot.takeout.dao.GiftMapper;


@Controller
public class GiftAction {

	@Resource
	private GiftMapper gm;
	
	@GetMapping("gifts.do")
	public String giftlist(Model m, String name) {
	
		List<Gift> list = gm.selectByExample(null);
		m.addAttribute("gift", list);
		
		return "gifts";
	}
	
	//物品对换
	@Resource
	private GiftsBiz gBiz;
	
	
	@GetMapping("buygift2")
	public void buygifts(Model m, Gift gift, Allotinf allotinf) {
		
		gBiz.buygift(gift, allotinf);
		
	}
}
