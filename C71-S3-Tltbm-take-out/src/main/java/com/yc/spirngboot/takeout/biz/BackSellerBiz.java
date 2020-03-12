package com.yc.spirngboot.takeout.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.bean.SellerExample;
import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.bean.UserExample;
import com.yc.spirngboot.takeout.dao.SellerMapper;
import com.yc.spirngboot.takeout.vo.encodeByMd5;

@Service
public class BackSellerBiz {

	@Resource
	private SellerMapper sm;
	
	public void reg(Seller seller) {
		//对密码进行md5加密
		encodeByMd5 md=new encodeByMd5();
		String newpwd=md.MD5(seller.getSpwd());
		seller.setSpwd(newpwd);
		sm.insertSelective(seller);
	}
	
	//商家登录
	public Seller selectBySeller(String sphone) throws BizExcption {
		SellerExample example=new SellerExample();
		example.createCriteria().andSphoneEqualTo(sphone);

		List<Seller> sellers=sm.selectByExample(example);
		if(sellers.size()==1) {
			return sellers.get(0);
		}else {
			throw new BizExcption("商家不存在"); 
		}
	}
}
