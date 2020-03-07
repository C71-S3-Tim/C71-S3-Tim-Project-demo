package com.yc.spirngboot.takeout.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.biz.BizExcption;
import com.yc.spirngboot.takeout.biz.UserBiz;
import com.yc.spirngboot.takeout.vo.Result;
import com.yc.spirngboot.takeout.vo.encodeByMd5;

@Controller
public class LoginAction {
	
	private UserBiz ubiz;
	@PostMapping("login.do")
	public Result login(String phone, String pwd,String vcode) {
		Result result=new Result();
		if(phone.trim().isEmpty()==true||pwd.trim().isEmpty()) {
			result.setCode(2);//2表示用户名或者密码为空
			result.setMsg("用户名或密码不能为空");
			return result;
		}
		encodeByMd5 md5=new encodeByMd5();
			String newpwd=md5.MD5(pwd);
		try {
			User user=ubiz.selectByUser(phone,newpwd);
			result.setData(user);
			result.setCode(0);
		} catch (BizExcption e) {
			e.printStackTrace();
			result.setMsg("用户名或密码错误");
			result.setCode(1);//用户名或密码错误
		}
		return result;
	}
}
