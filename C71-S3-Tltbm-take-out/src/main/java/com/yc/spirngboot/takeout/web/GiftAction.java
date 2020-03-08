package com.yc.spirngboot.takeout.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.spirngboot.takeout.bean.Gift;
import com.yc.spirngboot.takeout.bean.Giftorder;
import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.bean.UserExample;
import com.yc.spirngboot.takeout.biz.GiftsBiz;
import com.yc.spirngboot.takeout.dao.GiftMapper;
import com.yc.spirngboot.takeout.dao.UserMapper;
import com.yc.spirngboot.takeout.vo.Result;


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
	
	@Resource
	private UserMapper um;
	
	
	@PostMapping("buygift")
	@ResponseBody
	public Result buygifts(Model m, Integer gift_id, String customer_name, String customer_phone, String address,
			 Giftorder giftorder, HttpSession httpSession) {
		
		Gift gift = gm.selectByPrimaryKey(gift_id);
		Integer num = gift.getNumber();
		User users = (User) httpSession.getAttribute("loginedUser");
		User user2 = um.selectByPrimaryKey(users.getId());
		
		Result d=new Result();

		if(num<=0) {
			d.setData(gift);
			d.setMsg("礼品数量不足,请稍后再试！！");
			d.setCode(1);
		}else if(user2.getIntegral()<gift.getIntegral()){
			d.setData(gift);
			d.setMsg("氪星币不足！！");
			d.setCode(2);
		}else{
			d.setCode(0);
			gBiz.buygift(gift_id, customer_name, customer_phone, address, giftorder, httpSession);
			
			gBiz.updatanumber(gift_id);
		}
		
		return d;
	}
}
