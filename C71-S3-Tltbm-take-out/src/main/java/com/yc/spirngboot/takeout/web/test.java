package com.yc.spirngboot.takeout.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.biz.BizExcption;
import com.yc.spirngboot.takeout.biz.UserBiz;
import com.yc.spirngboot.takeout.vo.CookieUtils;
import com.yc.spirngboot.takeout.vo.Result;
import com.yc.spirngboot.takeout.vo.encodeByMd5;

@Controller
public class test {
	@GetMapping("test")
	public String test(Model m ,HttpServletResponse response) {
		CookieUtils myCookie=new CookieUtils();
	    myCookie.writeCookie(response, "integal", "111111");
		return "NewFile"; 
	}
	
	@GetMapping("getcookie")
	public String test2(Model m ,HttpServletRequest request) {
		CookieUtils myCookie=new CookieUtils();
		String value=myCookie.getCookie(request, "integal");
		System.out.println(""+value);
		return "NewFile"; 
	}
	
	@GetMapping("toindex")
	public String toIndex() {
		
		return "index";
	}
	
}
