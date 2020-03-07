package com.yc.spirngboot.takeout.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.spirngboot.takeout.bean.Collect;
import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.biz.CollectBiz;
import com.yc.spirngboot.takeout.vo.addrReturnResult;

@Controller
public class CollectAction {
	@Resource
	private CollectBiz cb;
	
	@GetMapping("collect.do")
	//访问收藏夹
	public String ToCollect(HttpSession hs,Model m) {
		
		User loingeduser=(User) hs.getAttribute("loginedUser");
		List<Collect> collects=cb.selectCollect(loingeduser.getId());
		System.out.println(collects);
		m.addAttribute("collects", collects);	
		return "member_collect";
	}
	
	//删除收藏
	@GetMapping("delectCollect")
	@ResponseBody
	public addrReturnResult delectCollect(String rid) {
		addrReturnResult r=new addrReturnResult();
		System.out.println("rid:"+ rid);
		r.setId(rid+"");
		if(rid!=null&&rid.trim().isEmpty()==false) {
			try {
				cb.deletCollect(Integer.parseInt(rid));
				r.setStatus("ok");
			}catch (Exception e) {
				e.printStackTrace();
				r.setStatus("删除失败！");
			}
			
		}else {
			r.setStatus("无效店铺");
		}
		return r;
	}

}
