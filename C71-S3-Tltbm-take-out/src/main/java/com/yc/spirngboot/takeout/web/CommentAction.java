package com.yc.spirngboot.takeout.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.biz.CommentBiz;
import com.yc.spirngboot.takeout.vo.Result;

@Controller
public class CommentAction {
	@Resource
	private CommentBiz cb;
	
	@PostMapping("comment.do")
	@ResponseBody
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

}
