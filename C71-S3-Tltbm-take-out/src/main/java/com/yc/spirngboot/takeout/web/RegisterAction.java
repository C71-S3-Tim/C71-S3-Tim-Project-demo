package com.yc.spirngboot.takeout.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.biz.UserBiz;
import com.yc.spirngboot.takeout.vo.Result;

@Controller
public class RegisterAction {
	@Resource
	private  UserBiz ubiz;

	@PostMapping("reg.do")
	public String reg(User user,String vcode) {
		System.out.println("user:"+user);
		System.out.println("vcode===:"+vcode);
		try{
			ubiz.reg(user);
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return "login";                                                     
		
	}
}
