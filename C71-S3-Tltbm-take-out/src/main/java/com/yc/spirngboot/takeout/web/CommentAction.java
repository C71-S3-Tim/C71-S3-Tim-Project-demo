package com.yc.spirngboot.takeout.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yc.spirngboot.takeout.bean.Comment;
import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.biz.CommentBiz;
import com.yc.spirngboot.takeout.biz.SellerBiz;
import com.yc.spirngboot.takeout.vo.Result;

@Controller
public class CommentAction {
	@Resource
	private CommentBiz cb;
	@Resource
	private SellerBiz sb;
	
	@PostMapping("comment.do")
	@ResponseBody
	//评论发表
	public Result docomment(String seller_id,String text,HttpSession hs) {
		//获取用户对像
		User logindedUser=(User) hs.getAttribute("loginedUser");
		System.out.println("seller_id:"+seller_id);
		System.out.println("text:"+text);
		Result r=new Result();
		if( text.trim().isEmpty()) {	
			r.setCode(1);
			r.setMsg("请输填写评论");
		}else if( seller_id.trim().isEmpty()) {
			r.setCode(2);
			r.setMsg("系统繁忙");
		}else {
			
			cb.addComment(seller_id, text, logindedUser.getId());
			r.setCode(0);
			r.setMsg("success");
		}
		
		return r;
		
	}
	//评论查看
	@GetMapping("selectComment")
	public String ToShopComent(String seller_id,Model m,int page) {
		Seller seller=sb.selectById(Integer.parseInt(seller_id));
	
		 PageHelper.startPage(page,5);
		Page<Comment> coms=cb.commentByPag();
		
		//将分页的数据推送到网页
		m.addAttribute("comments", coms);
		m.addAttribute("seller", seller);
		m.addAttribute("total",coms.getTotal());
		
		return "shop_comment";
	}
}
