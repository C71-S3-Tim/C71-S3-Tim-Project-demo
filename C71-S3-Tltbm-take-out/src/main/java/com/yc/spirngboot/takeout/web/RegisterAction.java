package com.yc.spirngboot.takeout.web;


import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.biz.RegBiz;

import Decoder.BASE64Encoder;




@Controller
public class RegisterAction {
	
	@Resource
	private RegBiz rBiz;

	
	@PostMapping("reg")
	public String reg(User user, Model m) {
		user.getPhone();
		user.getPwd();
		
		rBiz.reg(user);
		return "login";
	}
	
	@GetMapping("register.do")
	public String reg(Math m) {
		
		return "register";                                                     
	}
}
