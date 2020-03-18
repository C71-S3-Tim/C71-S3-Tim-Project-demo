package com.yc.spirngboot.takeout.admin.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.spirngboot.takeout.admin.biz.AdminBiz;
import com.yc.spirngboot.takeout.bean.Admin;
import com.yc.spirngboot.takeout.bean.AdminExample;
import com.yc.spirngboot.takeout.bean.Gift;
import com.yc.spirngboot.takeout.bean.GiftExample;
import com.yc.spirngboot.takeout.bean.Giftorder;
import com.yc.spirngboot.takeout.bean.GiftorderExample;
import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.bean.SellerExample;
import com.yc.spirngboot.takeout.biz.BizExcption;
import com.yc.spirngboot.takeout.dao.AdminMapper;
import com.yc.spirngboot.takeout.dao.GiftMapper;
import com.yc.spirngboot.takeout.dao.GiftorderMapper;
import com.yc.spirngboot.takeout.dao.SellerMapper;
import com.yc.spirngboot.takeout.vo.Result;

@Controller
public class admIndexAction {

	@GetMapping(path= {"admin/login","admin/login.do"})
	public String index() {
		return "admin/login";
	}
	
	@Resource
	private AdminMapper admm;
	
	@Resource
	private AdminBiz admBiz;
	
	@PostMapping("admin/admlogin")
	@ResponseBody
	public Result admlogin(String admusername, String admpass, Model m, HttpSession httpS) throws BizExcption {
		
		System.out.println("aaaaaaaaa=" + admusername + "bnbbb=" + admpass);
		Result res=new Result();
		
		AdminExample adminExample = new AdminExample();
		adminExample.createCriteria().andNameEqualTo(admusername);
		List<Admin> admins = admm.selectByExample(adminExample);
		
		Admin pwd = admins.get(0);
		
		if(admusername.trim().isEmpty() == true || admpass.trim().isEmpty() == true) {
			res.setData(admins);
			res.setMsg("用户名或密码不能为空");
			res.setCode(1);
			
		}else if(admins.size()==0) {
			res.setMsg("用户不存在");
			res.setCode(2);
			
		}else if(pwd.getPwd().equals(admpass)==false){
			res.setMsg("密码错误！"); 
			res.setCode(3);
		}else {
			res.setData(admins);
			res.setCode(0);
			httpS.setAttribute("loginedAdm", admins.get(0));
		}
		
		return res;
		
	}
	
	
	@Resource
	private SellerMapper admsm;
	
	@Resource
	private GiftorderMapper admgom;
	
	@Resource
	private AdminMapper adm;
	
	@Resource 
	private GiftMapper admgm;
	
	@GetMapping("admin/index")
	public String index(Model m, HttpSession httpS) {
		Admin adminss = (Admin) httpS.getAttribute("loginedAdm");
		Integer newzt = 1;
		Integer toage = 0;
		//正在运营店铺
		SellerExample sellerExample = new SellerExample();
		sellerExample.createCriteria().andQualifiedEqualTo(toage);
		List<Seller> sellerlist = admsm.selectByExample(sellerExample);
		m.addAttribute("sellernum", sellerlist.size());
		
		//待审核店铺
		SellerExample se = new SellerExample();
		se.createCriteria().andQualifiedEqualTo(newzt);
		List<Seller> sellertoage = admsm.selectByExample(se);
		m.addAttribute("toageseller", sellertoage.size());
		
		//礼品订单
		List<Giftorder> giftorders = admgom.selectByExample(null);
		m.addAttribute("giftorders", giftorders.size());

		//礼品已兑完
		GiftExample giftExample = new GiftExample();
		giftExample.createCriteria().andNumberEqualTo(toage);
		List<Gift> togiftnum = admgm.selectByExample(giftExample);
		m.addAttribute("nogiftnums", togiftnum.size());
		
		//礼品
		List<Gift> giftnum = admgm.selectByExample(null);
		m.addAttribute("giftnums", giftnum.size());
		
		//审核比例
		List<Seller> allseller = admsm.selectByExample(null);
		
		Float all = (float) allseller.size();
		Float agre = (float) sellerlist.size();
		
		Float bl = (agre/all)*100;
		m.addAttribute("bili", bl.byteValue());
		
		
		
		return "admin/index";
		}
}
