package com.yc.spirngboot.takeout.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.spirngboot.takeout.biz.YZMBiz;

@Controller
public class Testyzm {
	
	@Resource
	private YZMBiz yb;
	
	@GetMapping("YZM")
	public String YZM(Model m, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse ) {
		
		yb.imgvrifyControllerDefaultKaptcha(httpServletRequest, httpServletResponse);
		
		return "YZM";
		
	}
	
}
