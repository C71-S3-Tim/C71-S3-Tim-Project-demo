package com.yc.spirngboot.takeout.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.bean.UserExample;
import com.yc.spirngboot.takeout.dao.UserMapper;
import com.yc.spirngboot.takeout.vo.encodeByMd5;

@Service
public class UserBiz {
	@Resource
	private UserMapper um;
	
	public void reg(User user) {
		//对密码进行md5加密
		encodeByMd5 md=new encodeByMd5();
		String newpwd=md.MD5(user.getPwd());
		user.setPwd(newpwd);
		//System.out.println(user);
		um.insertSelective(user);
	
	}

	public User selectByUser(String phone,String pwd) throws BizExcption {
		UserExample ue=new UserExample();
		ue.createCriteria().andPhoneEqualTo(phone)
							.andPwdEqualTo(pwd);
		List<User> users=um.selectByExample(ue);
		if(users.size()==1) {
			return users.get(0);
		}else {
			throw new BizExcption("用户不存在");
			
		}
	}

}
