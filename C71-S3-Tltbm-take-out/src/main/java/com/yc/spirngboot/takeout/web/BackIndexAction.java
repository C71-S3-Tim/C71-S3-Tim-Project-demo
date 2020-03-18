package com.yc.spirngboot.takeout.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yc.spirngboot.takeout.bean.Dayandcount;
import com.yc.spirngboot.takeout.bean.Good;
import com.yc.spirngboot.takeout.bean.Orderinfo;
import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.biz.BackSellerBiz;
import com.yc.spirngboot.takeout.biz.BizExcption;
import com.yc.spirngboot.takeout.biz.GoodBiz;
import com.yc.spirngboot.takeout.biz.OrderInfoBiz;
import com.yc.spirngboot.takeout.dao.SellerMapper;
import com.yc.spirngboot.takeout.vo.CookieUtils;
import com.yc.spirngboot.takeout.vo.Result;

@Controller
public class BackIndexAction {
	@Resource
	private SellerMapper sm; 
	@Resource
	private GoodBiz gb;
	@Resource
	private OrderInfoBiz ob;
	@Resource
	private BackSellerBiz bsbiz;
	
	@GetMapping("toBackIndex")
	public String toBackIndex(Model m,HttpSession hs,HttpServletRequest request) {
		Seller seller=(Seller) hs.getAttribute("loginedSeller");
		int s_id=seller.getId();
		int order=bsbiz.order(s_id);
		//评论
		int allcomments=bsbiz.comment(s_id);
		m.addAttribute("allcomments",allcomments);
		int todaycomments=bsbiz.Todaycomment(s_id);
		m.addAttribute("todaycomments",todaycomments);	
		int add=(todaycomments*100)/allcomments;
		m.addAttribute("add",add);
		//收藏
		int collects=bsbiz.collect(s_id);
		m.addAttribute("collects", collects);
		//订单数
		int orders=bsbiz.orders(s_id);
		m.addAttribute("orders",orders);
		int todayorders=bsbiz.TodayOrders(s_id);
		m.addAttribute("todayorders",todayorders);
		int addOrder=(todayorders*100)/orders;
		m.addAttribute("addOrder",addOrder);
		//待支付订单数
		int needorders=bsbiz.NeedOrders(s_id);
		m.addAttribute("needorders",needorders);
		int addneedOrder=(needorders*100)/order;
		m.addAttribute("addneedOrder",addneedOrder);
		//下单数
		//int order=bsbiz.order(s_id);
		m.addAttribute("order",order);
		//收益
		int money=bsbiz.money(s_id);
		m.addAttribute("money",money);
		
		
		
		
		
		
		//从登陆用户中获取Seller
		//Seller s=(Seller) hs.getAttribute("loginedSeller");
		Seller s=new Seller();
		s=sm.selectByPrimaryKey(1);
		m.addAttribute("seller", s);
		//从cookie中取出访问量
		CookieUtils myCookie=new CookieUtils();
		String count=myCookie.getCookie(request, "webvisit"+s.getId());
		System.out.println("日访问数："+count);
		//将访问数推送到前端
		m.addAttribute("visitCount", count);
		//商铺订单
		List<Orderinfo> orders1=ob.selectBySeller_id(s.getId());
		//统计报表
		List<Dayandcount> list=ob.selectWeekAndCount(s.getId());
		//将数组转成jsong
		 ObjectMapper mapper = new ObjectMapper();
		 try {
			String json2=mapper.writeValueAsString(list);
			m.addAttribute("Weekorders",json2);
		} catch (JsonProcessingException e) {
		
			e.printStackTrace();
		}
		
		m.addAttribute("goods",s.getGoods());
		m.addAttribute("ordersize",orders1.size());
		return "back/index";
		
	}
	@PostMapping("showgood.do")
	@ResponseBody
	public Result showgood(String gid,Model m) {
		System.out.println(gid+"============");
		Result r=new Result();
		if(gid.trim().isEmpty()==false&&gid!=null) {
			int id=Integer.parseInt(gid);
			try {
				Good  seledtgood=gb.selectById(id);
				r.setData(seledtgood);
				r.setCode(0);
				r.setMsg("操作成功！");
				m.addAttribute("selectgood", seledtgood);
			} catch (BizExcption e) {
				e.printStackTrace();
			}
			
		}else {
			r.setCode(1);
			r.setMsg("业务繁忙！");
		}
		return r;
	}
	
	@PostMapping("deletegood.do")
	@ResponseBody
	public Result deletegood(String gid) {
		System.out.println(gid+"============");
		Result r=new Result();
		if(gid.trim().isEmpty()==false&&gid!=null) {
			int id=Integer.parseInt(gid);
			gb.deleteById(id);
			r.setCode(0);
			r.setMsg("操作成功！");
		}else {
			r.setCode(1);
			r.setMsg("业务繁忙！");
		}
		return r;
	}
	
	//修改good
	@PostMapping("updategood")
	@ResponseBody
	public Result updateGood(@RequestParam("file") MultipartFile pPicture,String gname,String number,String  price,String gid) {
		Result r=new Result();
		Good g=new Good();
		//文件上传
		String fileName = UUID.randomUUID()+ pPicture.getOriginalFilename();
		System.out.println(fileName);
		try {
			if(!pPicture.isEmpty()){
		        byte [] bytes = pPicture.getBytes();
		        BufferedOutputStream bufferedOutputStream = new
		                BufferedOutputStream(new FileOutputStream(new File("E:\\upload\\"+fileName)));
		        bufferedOutputStream.write(bytes);
		        bufferedOutputStream.close();
		        String path="images/good/"+fileName;
		        System.out.println(path);
		        g.setImage(path);
		    }
		} catch (IOException e) {
			e.printStackTrace();
			r.setCode(-1);
			r.setMsg("文件上传失败！");
			return r;
		}
		g.setId(Integer.parseInt(gid));
		g.setNumber(Integer.parseInt(number));
		g.setGname(gname);
		g.setPrice(Float.parseFloat(price));
		System.out.println(g);
		
		try {
			gb.updateGood(g);
			r.setCode(0);
			r.setMsg("修改成功！");
		}catch (Exception e) {
			r.setCode(1);
			r.setMsg("系统繁忙请稍后再试！");
		}
		
		return r;
	}
//增加good
	@PostMapping("addgood")
	@ResponseBody
	public Result AddGood(@RequestParam("file") MultipartFile pPicture,String gname,String number,String  price,String gid) {
		Result r=new Result();
		Good g=new Good();
		//文件上传
		String fileName = UUID.randomUUID()+ pPicture.getOriginalFilename();
		System.out.println(fileName);
		try {
			if(!pPicture.isEmpty()){
		        byte [] bytes = pPicture.getBytes();
		        BufferedOutputStream bufferedOutputStream = new
		                BufferedOutputStream(new FileOutputStream(new File("E:\\upload\\"+fileName)));
		        bufferedOutputStream.write(bytes);
		        bufferedOutputStream.close();
		        String path="images/good/"+fileName;
		        System.out.println(path);
		        g.setImage(path);
		    }
		} catch (IOException e) {
			e.printStackTrace();
			r.setCode(-1);
			r.setMsg("文件上传失败！");
			return r;
		}
		
		g.setNumber(Integer.parseInt(number));
		g.setGname(gname);
		g.setPrice(Float.parseFloat(price));
		//从登陆用户中获取Seller
		//Seller s=(Seller) hs.getAttribute("loginedSeller");
		//g.setSellerId(s.getId());
		g.setSellerId(1);
		
		//动态设置状态
		if(Integer.parseInt(number)>1) {
			g.setStatus(0);
		}else {
			g.setStatus(1);
		}
		//动态生成积分数
		int integral=(int) (Float.parseFloat(price)*0.8);
		g.setIntegral(integral);
		
		System.out.println(g);
		
		try {
			gb.addGood(g);
			r.setCode(0);
			r.setMsg("新增成功！");
		}catch (Exception e) {
			e.printStackTrace();
			r.setCode(1);
			r.setMsg("系统繁忙请稍后再试！");
		}
		
		return r;
	}
	
}
