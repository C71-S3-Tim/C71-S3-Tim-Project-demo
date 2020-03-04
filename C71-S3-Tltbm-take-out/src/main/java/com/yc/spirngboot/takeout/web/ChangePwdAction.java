package com.yc.spirngboot.takeout.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.biz.UserBiz;
import com.yc.spirngboot.takeout.vo.Result;
import com.yc.spirngboot.takeout.vo.encodeByMd5;

@Controller
public class ChangePwdAction {

	@Resource
	private UserBiz ubiz;
	
	@PostMapping("change.do")
	@ResponseBody()
	public Result change(String old_password,String new_password,Model m,HttpSession hs) {
		User loginedUser=(User) hs.getAttribute("loginedUser");
		
		//得到数据库中的密码
		String pwdbycu=loginedUser.getPwd();
		
		encodeByMd5 md5=new encodeByMd5();
		//进行不可逆加密MD5
		String pwdbymd5=md5.MD5(old_password);
		
		/*1、如果密码一样且 d.setStatus("ok");
		2、如果密码不一样 d.setStatus("other str");
						a：d.setFailed_code(1019);  输入的密码有误 old_password
						b: d.setFailed_code("1028");密码为6 - 10位字符*/
		Result d=new Result();
		
		if(!pwdbycu.equals(pwdbymd5)) {
			d.setFailed_code("1019");
		}else {
			ubiz.change(loginedUser, new_password);
			d.setStatus("ok");	
		}
		return d;
	}
}
