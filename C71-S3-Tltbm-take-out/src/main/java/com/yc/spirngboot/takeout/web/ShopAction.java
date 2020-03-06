package com.yc.spirngboot.takeout.web;


import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.yc.spirngboot.takeout.bean.Good;
import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.biz.BizExcption;
import com.yc.spirngboot.takeout.biz.GoodBiz;
import com.yc.spirngboot.takeout.biz.OrderBiz;
import com.yc.spirngboot.takeout.biz.SellerBiz;
import com.yc.spirngboot.takeout.biz.UserBiz;
import com.yc.spirngboot.takeout.vo.CookieUtils;
import com.yc.spirngboot.takeout.vo.JsonToMap;
import com.yc.spirngboot.takeout.vo.PlayByAiLi;


@RestController
public class ShopAction {
	@Resource
	private GoodBiz gb;
	@Resource
	private SellerBiz sb;
	@Resource
	private OrderBiz ob;
	
	
	@PostMapping("shop.do")
	public String shop(@RequestParam Map<String,String> map,HttpServletResponse response,String sellerid,HttpSession hs) {
		Map<String, Object> jsonMap= JsonToMap.jsonToMap(map.get("jsonData"));
		//获取用户对像
				User logindedUser=(User) hs.getAttribute("loginedUser");
		
		//获取键值对计算价格
				//商品总积分
				int integal=0;
		 		//商品总价
		 		int total=0;
		 		//支付页面信息
		 		String pag="";
		 		//每次订单生成对应的订单编号                                                                                                                                                                                                                                                                                                                 
		 		String order_number = CreateOrderCode(sellerid);
		 		//获取卖家id
		 		int seller_id=Integer.parseInt(sellerid);
		 		//将商家id存入会话	 
				 hs.setAttribute("seller_id", seller_id);
				 //将订单编号存入会话
				 hs.setAttribute("order_number", order_number);
		 		
		 		//生成订单的时间
		 		Date ordertime=creatTiem();
		 		//生成订单配送的时间
		 		int sendtime=30+seller_id*2+seller_id;
		    for (Entry<String, Object> entry:jsonMap.entrySet()){
		    	try {
					Good good=gb.selectById(Integer.parseInt(entry.getKey()));
					
					//计算总价格
					String str=entry.getValue()+"";
					int munber=Integer.parseInt(str);
					 total+=good.getPrice()*munber;
					 //计算总积分
					 integal+=good.getIntegral()*munber;
					//将订单信息写入订单表
					ob.createOrder(good, ""+seller_id, munber, order_number, sendtime, ordertime);
					  response.setContentType("text/html;charset=utf-8");
		    	} catch (NumberFormatException | BizExcption e) {
					e.printStackTrace();
				}
		    	
		      System.out.print("得到键为：==="+entry.getKey());
		      System.out.println("得到值为：==="+entry.getValue());
		    }
		  //将积分写加入Cookie中 因为支付宝页面跳转sseion失效
		    hs.setAttribute("integal", integal);
		    CookieUtils myCookie=new CookieUtils();
		    myCookie.writeCookie(response, "integal", ""+integal);
		    myCookie.writeCookie(response, "phone", logindedUser.getPhone());
		
		   
		return pag;
		
	}
	//生成不重复订单号
		public String CreateOrderCode(String ordleld) {
			Random r = new Random();
			String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
	        String code=""+s.charAt(r.nextInt(s.length()))+s.charAt(r.nextInt(s.length()))+s.charAt(r.nextInt(s.length()))+s.charAt(r.nextInt(s.length()))+ordleld;
	        return code;
		}
		//创建订单时间
		public Date creatTiem() {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	 		String time = LocalDateTime.now().format(formatter);
	 		
	 		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
	 		java.sql.Date sDate = null;
	        try {
	            java.util.Date date3 = sdf2.parse(time);
	            sDate = new java.sql.Date(date3.getTime());
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return sDate;
		}
}
