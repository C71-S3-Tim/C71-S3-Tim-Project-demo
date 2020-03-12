package com.yc.spirngboot.takeout.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.biz.BackSellerBiz;
import com.yc.spirngboot.takeout.biz.BizExcption;
import com.yc.spirngboot.takeout.vo.Result;
import com.yc.spirngboot.takeout.vo.encodeByMd5;

@Controller	
public class BackLoginAction {
	@Resource
	private BackSellerBiz bsbiz;
	
	@GetMapping("backlogin.do")
	public String login() {
		
		return "back/login";
	}
	
	
	@PostMapping("backindex.do")
	@ResponseBody()
	public Result login(String sphone, String spwd,Model m,HttpSession hs) {

		Result result=new Result();
		if(sphone.trim().isEmpty()==true||spwd.trim().isEmpty()) {
			result.setCode(2);//2表示用户名或者密码为空
			result.setMsg("用户名或密码不能为空");
			return result;
		}
		encodeByMd5 md5=new encodeByMd5();
			String newpwd=md5.MD5(spwd);
		try {
			Seller seller=bsbiz.selectBySeller(sphone);
			if(seller.getSpwd().equals(newpwd)) {
				result.setData(seller);
				result.setCode(0);
				hs.setAttribute("loginedSeller", seller);
			}else {
				result.setMsg("用户名或密码错误");
				result.setCode(1);//用户名或密码错误
			}
		} catch (BizExcption e) {	

			result.setMsg(e.getMessage());

			result.setCode(3);  //用户不存在

		}
		return result;
	}

	@GetMapping("backindex.do")
	public String index() {
		
		return "back/index";
	}
	
}
