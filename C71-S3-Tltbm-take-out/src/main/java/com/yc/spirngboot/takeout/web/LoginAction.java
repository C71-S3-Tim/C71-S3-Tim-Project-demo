package com.yc.spirngboot.takeout.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.yc.spirngboot.takeout.bean.Orderinfo;

import com.yc.spirngboot.takeout.bean.OrderinfoExample.Criteria;
import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.biz.BizExcption;
import com.yc.spirngboot.takeout.biz.UserBiz;
import com.yc.spirngboot.takeout.dao.UserMapper;
import com.yc.spirngboot.takeout.vo.Result;
import com.yc.spirngboot.takeout.vo.encodeByMd5;


@Controller
/*@SessionAttributes({"loginedUser","vcode"})*/
public class LoginAction {

	@Resource
	private UserBiz ubiz;
	@Resource
	private UserMapper um;
	
	
	@GetMapping(path= {"/","index","index.do"})
	public String index(Model m,HttpSession hs) {
		if(hs.getAttribute("loginedUser")!=null) {
			List<Seller> hotseller=ubiz.hotquery();
			m.addAttribute("hotsellers",hotseller);
		}
		return "index";
	}
	
	
	@PostMapping("login.do")
	@ResponseBody()
	public Result login(String phone, String pwd,String vcode,Model m,HttpSession hs) {

		System.out.println("===========");
		

		Result result=new Result();
		if(phone.trim().isEmpty()==true||pwd.trim().isEmpty()) {
			result.setCode(2);//2表示用户名或者密码为空
			result.setMsg("用户名或密码不能为空");
			return result;
		}
		encodeByMd5 md5=new encodeByMd5();
			String newpwd=md5.MD5(pwd);
		try {
			User user=ubiz.selectByUser(phone);
			if(user.getPwd().equals(newpwd)) {
				result.setData(user);
				result.setCode(0);
				//m.addAttribute("loginedUser", user);
				hs.setAttribute("loginedUser", user);
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



	
	//账号管理
	@RequestMapping("account")
	public String tom(HttpSession hs,Model m,Orderinfo orderinfo) {
		//System.out.println(hs.getAttribute("loginedUser"));	
		int allorders=ubiz.allorders();
		m.addAttribute("allorders",allorders);
		
		int sucOrders=ubiz.sucessorders();
		m.addAttribute("sucOrders",sucOrders);
		m.addAttribute("loginedUser",hs.getAttribute("loginedUser"));
		return "member_index";
	}
		
	//查找餐厅
	@PostMapping("query.do")
	public String query(Model m,String sname) {
		List<Seller> sellers=ubiz.query(sname);
		//将数组转成jsong
		 ObjectMapper mapper = new ObjectMapper();
		try {
			String json2=mapper.writeValueAsString(sellers);
			m.addAttribute("sellers1", json2);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		m.addAttribute("sellers",sellers);
		m.addAttribute("size",sellers.size());
		return "shop_list";
	}
	

}
