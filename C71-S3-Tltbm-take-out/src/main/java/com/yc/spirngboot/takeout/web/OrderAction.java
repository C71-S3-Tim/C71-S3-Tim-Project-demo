package com.yc.spirngboot.takeout.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yc.spirngboot.takeout.bean.Allotinf;
import com.yc.spirngboot.takeout.bean.Myorder;
import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.biz.AllotinfBiz;
import com.yc.spirngboot.takeout.biz.MyAddrBiz;
import com.yc.spirngboot.takeout.biz.OrderBiz;
import com.yc.spirngboot.takeout.biz.SellerBiz;
import com.yc.spirngboot.takeout.biz.UserBiz;
import com.yc.spirngboot.takeout.vo.CookieUtils;
import com.yc.spirngboot.takeout.vo.OrderAddr;
import com.yc.spirngboot.takeout.vo.PlayByAiLi;
import com.yc.spirngboot.takeout.vo.addrReturnResult;
import com.yc.spirngboot.takeout.vo.orderIteam;

@Controller
public class OrderAction {
	@Resource
	private MyAddrBiz mob;
	@Resource
	private OrderBiz ob;
	@Resource
	private SellerBiz sb;
	@Resource
	private UserBiz ub; 
	
	@GetMapping("toOrder")
	public String createOrder(HttpSession hs,Model m) {
		//获取商家id
		String seller_id=""+hs.getAttribute("seller_id");
		//获取订单编号
		String order_number=""+ hs.getAttribute("order_number");
		//获取用户对像
		User logindedUser=(User) hs.getAttribute("loginedUser");

		//System.out.println("userid:"+logindedUser.getId());
		List<Allotinf> addrs=mob.addr(logindedUser.getId());
		//将数据库地址数据转成Agular 前台的数据结构类型
		OrderAddr orderaddr=new OrderAddr();
		List<OrderAddr>	 orderaddrs=orderaddr.toOrder(addrs);
		//将地址数据转成jsong
		tojsonAndModel(orderaddrs,"addrsjson",m);
		
		//根据订单编号查询购物信息
		List<Myorder> orders= ob.selectByOrder_number(order_number);
		m.addAttribute("orders", orders);
		
		//将总价存入model  默认没有使用 优惠券（优惠有bug）
		int sid=Integer.parseInt(seller_id);
		Seller seller=sb.selectById(sid);
		int Tatolmoney=(int) (ob.tatoalmMoney(orders,null));
		m.addAttribute("Tatolmoney", Tatolmoney);
		//将包装费传入
		m.addAttribute("packprice", seller.getPackprice());
		
		System.out.println("seller_id==="+seller_id);
		System.out.println("order_number==="+order_number);
		
		
		return "order";
	}
	@PostMapping("toPay")
	@ResponseBody
	public String pay(String totalMoney,HttpSession hs) {
		//获取商家id
		String seller_id=""+hs.getAttribute("seller_id");
		int sid=Integer.parseInt(seller_id);
		//获取订单编号
		String order_number=""+ hs.getAttribute("order_number");
		//获取购物积分
		int  intergal=(int) hs.getAttribute("integal");
		//获取用户对像
		User logindedUser=(User) hs.getAttribute("loginedUser");
		
		String payform="";
		//支付页面
		try {
			 PlayByAiLi play=new PlayByAiLi();
			 String sellername=sb.selectnameByKey(sid);
			 payform=play.ali(order_number, totalMoney, sellername);
		} catch (AlipayApiException | IOException e) {
		
			e.printStackTrace();
		}
		//将积分加入
		System.out.println("logindedUser.getId()"+logindedUser.getId());
		ub.addIntegal(intergal,logindedUser.getId());
		
		//订单完成取消session
		hs.removeAttribute("seller_id");
		hs.removeAttribute("order_number");
		return payform;
		
	}
	@GetMapping("order_success")
	public String order_success(HttpServletRequest request,HttpSession hs,Model m){	
		//获取购物积分
		CookieUtils myCookie=new CookieUtils();
		String strIntegal= myCookie.getCookie(request, "integal");;
		System.out.println("intergal"+strIntegal);
		int  intergal=Integer.parseInt(strIntegal);
		
		String phone=myCookie.getCookie(request, "phone");
		System.out.println("phone"+phone);
		
		m.addAttribute("phone", phone);
		m.addAttribute("intergal", intergal);
		return "order_success";
		
	}
	
	
	/**
	 * 地址新增
	 * @param addr
	 * @return
	 */
	@PostMapping("toaddAddraddress")
	@ResponseBody
	public addrReturnResult toaddAddraddress(HttpSession hs,OrderAddr addr) {
		//获取用户对像
		User logindedUser=(User) hs.getAttribute("loginedUser");
		int uid=logindedUser.getId();
		
		addrReturnResult d=new addrReturnResult();
		int id=mob.addAddr(addr,uid);
		//int id=mob.addAddr(addr,19);
		
		d.setStatus("ok");
		d.setId(""+id);
		
		return d;
	}
	
	/**
	 * 修改地址
	 * @param addr
	 * @return
	 */
	@PostMapping("toUpdateAddr")

	@ResponseBody
	public addrReturnResult toUpdateAddr(HttpSession hs,OrderAddr addr) {
		System.out.println("update==================================="+addr.getId());
		//获取用户对像
		User logindedUser=(User) hs.getAttribute("loginedUser");
		int uid=logindedUser.getId();
		System.out.println(uid+"==============");
		//addr.setId(addr_id);	
		addrReturnResult d=new addrReturnResult();
		int id=mob.updateAddr(addr,uid);
		//int id=mob.updateAddr(addr,19);
		
		d.setStatus("ok");
		d.setId(""+id);
		
		return d;
	}
	/**
	 * 删除地址
	 * @param addr
	 * @return
	 */
	@PostMapping("deleteAddr")
	@ResponseBody
	public addrReturnResult deleteAddr(HttpSession hs,OrderAddr addr,String param ) {
		addrReturnResult d=new addrReturnResult();
		int id=mob.deletAddr(addr);
		d.setStatus("ok");
		d.setId(""+id);
		return d;
	}
	
	//将数据转成json并存入Mdoel 中
	public void tojsonAndModel(Object obj,String paramName,Model m) {
		 ObjectMapper mapper = new ObjectMapper();
			try {
				String addrsjson=mapper.writeValueAsString(obj);
				m.addAttribute(paramName, addrsjson);
			} catch (JsonProcessingException e) {
				
				e.printStackTrace();
			}
			
	}
}
