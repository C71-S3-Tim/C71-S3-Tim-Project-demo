package com.yc.spirngboot.takeout.web;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.bean.UserExample;
import com.yc.spirngboot.takeout.biz.RegBiz;
import com.yc.spirngboot.takeout.biz.YZMBiz;
import com.yc.spirngboot.takeout.dao.UserMapper;
import com.yc.spirngboot.takeout.vo.Result;



@Controller
public class RegisterAction {
	
	
	
	@GetMapping("register.do")
	public String reg(Math m) {
		
		
		
		return "register";                                                     
	}
	@GetMapping("return.do")
	public String returnlogin(Math m) {
		return "index";                                                     
	}

	@Resource
	private RegBiz rBiz;
	
	@Resource
	private UserMapper um;
	
	@Resource
	private YZMBiz yb;
	
	@PostMapping("reg")
	@ResponseBody()
	public Result reg(User user, String phone, String pwd, String pwd2, String yzm, Model m, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		//验证码
		yb.imgvrifyControllerDefaultKaptcha(httpServletRequest, httpServletResponse);
		String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
	    System.out.println("图片== "+captchaId+" 输入内容== " + yzm);
		
		//获取数据库内已注册手机号
		UserExample userExample = new UserExample();
		userExample.createCriteria().andPhoneEqualTo(phone);
		List<User> users = um.selectByExample(userExample);
		
		//验证
		Result result=new Result();
		if(phone.trim().isEmpty()==true||pwd.trim().isEmpty()==true || pwd2.trim().isEmpty()==true) {
			result.setData(user);
			
			result.setMsg("手机号码或密码不能为空！！！");
			result.setCode(2);
			
		}else if(pwd.equals(pwd2)==false) {
			result.setData(user);
			result.setMsg("两次密码不一致！！！");
			result.setCode(1);
			
		}else if(phone.length()!=11){
			result.setData(user);
			result.setMsg("手机号码格式错误！！！");
			result.setCode(1);
			
		}else if(pwd.length() < 6 ){
			result.setData(user);
			result.setMsg("密码不得低于六位！！！");
			result.setCode(1);
		}else if(!captchaId.equals(yzm)) {
			result.setData(user);
			result.setMsg("请输入正确的验证码！！！");
			result.setCode(4);
		}else if(users.size()==0) {
			result.setCode(0);
			rBiz.register(user);
		}else {
			
			result.setMsg("该手机号码已注册！！！");
			result.setCode(3);
		}
		return result;
	}
		
	
}
