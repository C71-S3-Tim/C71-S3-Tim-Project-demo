package com.yc.spirngboot.takeout.web;



import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.biz.BizExcption;
import com.yc.spirngboot.takeout.biz.UserBiz;
import com.yc.spirngboot.takeout.vo.CookieUtils;
import com.yc.spirngboot.takeout.vo.Result;
import com.yc.spirngboot.takeout.vo.encodeByMd5;

import redis.clients.jedis.Jedis;

@Controller
public class test {
	
	private int s=0;

	@GetMapping("getcookie")
	public String test2(Model m ,HttpServletRequest request,HttpServletResponse response ) {
		CookieUtils myCookie=new CookieUtils();
		
		String count=myCookie.getCookie(request, "webvisit");
		if(count!=null&&count.trim().isEmpty()==false) {
				s=Integer.parseInt(count);
				s++;
		}
		myCookie.writeCookie(response, "webvisit", ""+s);
		System.out.println("-----"+myCookie.getCookie(request, "webvisit"));
		s++;
		return "NewFile";
	}
	
	
	@PostMapping("testupload")
	@ResponseBody
	public void test3(@RequestParam("file") MultipartFile pPicture,String gname) throws IOException {
		
       
		System.out.println(gname);
		String fileName = UUID.randomUUID()+ pPicture.getOriginalFilename();
		System.out.println(fileName);
		if(!pPicture.isEmpty()){
	        byte [] bytes = pPicture.getBytes();
	        BufferedOutputStream bufferedOutputStream = new
	                BufferedOutputStream(new FileOutputStream(new File("E:\\upload\\"+fileName)));
	        bufferedOutputStream.write(bytes);
	        bufferedOutputStream.close();
	    }
			s++;
	}
	
	

}
