package com.yc.spirngboot.takeout.biz;


import java.util.Random;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.dao.UserMapper;
import com.yc.spirngboot.takeout.vo.encodeByMd5;

@Service
public class RegBiz {
	
	//生成随机数
	 public static String getRandomCode(Integer code){
	        Random random = new Random();
	        StringBuffer result= new StringBuffer();
	        for (int i=0;i<code;i++){
	            result.append(random.nextInt(10));
	        }
	        return result.toString();
	    }
	
	@Resource
	private UserMapper um;
	
	public void register(User user) {
		
		//数据库掩码处理
		encodeByMd5 md=new encodeByMd5();
		String newpwd = md.MD5(user.getPwd());
		user.setPwd(newpwd);
		
		//获得随机账号
		String uname = getRandomCode(10);
		user.setUname(uname);

		um.insert(user);
	}
}
