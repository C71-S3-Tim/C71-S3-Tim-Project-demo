package com.yc.spirngboot.takeout.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.spirngboot.takeout.bean.City;
import com.yc.spirngboot.takeout.bean.District;
import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.bean.SellerExample;
import com.yc.spirngboot.takeout.biz.IndexBiz;
import com.yc.spirngboot.takeout.dao.SellerMapper;
import com.yc.spirngboot.takeout.vo.Result;

@Controller
public class IndexAction {

	
	@Resource
	private IndexBiz iBiz;
	@Resource
	private SellerMapper sm;
	
	@PostMapping("newseller")
	@ResponseBody
	public Result newshop(Seller seller, City city, District district, 
			String sname, String sphone, String name, String dname, Model m) {
		//获取已注册商家名
		SellerExample sellerExample = new SellerExample();
		sellerExample.createCriteria().andSnameEqualTo(sname);
		List<Seller> sellers = sm.selectByExample(sellerExample);
		
		//验证
		Result result=new Result();
		if(sphone.trim().isEmpty()==true||sname.trim().isEmpty()==true ) {
			result.setData(seller);
			
			result.setMsg("信息不能为空！！！");
			result.setCode(1);
			
		}else if(name.equals("请选择城市")) {
			result.setData(seller);
			
			result.setMsg("请填写城市信息");
			result.setCode(2);
		}else if(sphone.length()!=11){
			result.setData(seller);
			result.setMsg("手机号码格式错误！！！");
			result.setCode(1);
			
		}else if(sellers.size()!=0) {
			result.setData(seller);
			result.setMsg("该商店名已被注册！！！");
			result.setCode(1);
		}else {
			result.setData(seller);
			result.setCode(0);
			//添加地址
			iBiz.cityanddist(city, district);
			//添加商店
			iBiz.newseller(seller, city);
		}
			
		return result;
	}
	
}
