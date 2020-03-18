package com.yc.spirngboot.takeout.admin.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.spirngboot.takeout.admin.biz.admSellerBiz;
import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.dao.CityMapper;
import com.yc.spirngboot.takeout.dao.SellerMapper;
import com.yc.spirngboot.takeout.vo.Result;

@Controller
public class admSellerAction {

	@Resource
	private SellerMapper admsm;
	
	@Resource
	private CityMapper admcm;
	
	@Resource
	private admSellerBiz admsbiz;
	
	@GetMapping("admin/seller.do")
	public String admgift(Model m) {
		
		List<Seller> sellerlist = admsm.selectByExample(null);
		
		m.addAttribute("sellerlist", sellerlist);
		m.addAttribute("sellernum", sellerlist.size());
		
		return "admin/Sellerlist";
	}
	
	
	@PostMapping("admin/deleteseller.do")
	@ResponseBody
	public Result deleteseller(Integer sid) {
		System.out.println(sid+"============");
		Result result=new Result();
		if(sid!=null) {
			
			admsbiz.deleteseller(sid);
			result.setCode(0);
			result.setMsg("操作成功！");
		}else {
			result.setCode(1);
			result.setMsg("业务繁忙！");
		}
		return result;
	}
	
	
	@PostMapping("admin/agreeseller.do")
	@ResponseBody
	public Result agreeseller(Integer sid) {
		System.out.println(sid+"============");
		Result result=new Result();
		if(sid!=null) {
			
			admsbiz.agreeseller(sid);
			result.setCode(0);
			result.setMsg("操作成功！");
		}else {
			result.setCode(1);
			result.setMsg("业务繁忙！");
		}
		return result;
	}
	
	@PostMapping("admin/disagreeseller.do")
	@ResponseBody
	public Result disagreeseller(Integer sid) {
		Result result=new Result();
		if(sid!=null) {
			
			admsbiz.disagreeseller(sid);
			result.setCode(0);
			result.setMsg("操作成功！");
		}else {
			result.setCode(1);
			result.setMsg("业务繁忙！");
		}
		return result;
	}
}
