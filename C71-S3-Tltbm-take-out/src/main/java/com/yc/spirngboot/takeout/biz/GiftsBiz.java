package com.yc.spirngboot.takeout.biz;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.Gift;
import com.yc.spirngboot.takeout.bean.Giftorder;
import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.dao.GiftMapper;
import com.yc.spirngboot.takeout.dao.GiftorderMapper;
import com.yc.spirngboot.takeout.dao.UserMapper;

@Service
public class GiftsBiz {

	@Resource
	private GiftMapper gm;
	
	//数量更新
	public void updatanumber(Integer gift_id) {
		System.out.println("获得的商品id=" + gift_id);
		Gift gift = gm.selectByPrimaryKey(gift_id);
		
		gift.setNumber(gift.getNumber()-1);
		
		gm.updateByPrimaryKey(gift);
	}
	
	@Resource
	private GiftorderMapper gom;
	
	@Resource
	private UserMapper um;
	
	public void buygift(Integer gift_id, String customer_name, 
			String customer_phone, String address, Giftorder giftorder, HttpSession httpSession) {
		Gift gift = gm.selectByPrimaryKey(gift_id);
		
		System.out.println("=====mingzmingzi====="+  gift.getName());
		System.out.println("=====Integral====="+  gift.getIntegral());
		System.out.println("=====address====="+  address);
		//传值到兑换账单
		giftorder.setCustomeraddress(address);
		giftorder.setCustomername(customer_name);
		giftorder.setCustomerphone(customer_phone);
		giftorder.setGiftname(gift.getName());
		giftorder.setIntegral(gift.getIntegral());
		
		User user = (User) httpSession.getAttribute("loginedUser");
		giftorder.setuId(user.getId());
		
		gom.insert(giftorder);
		
		
		//更新用户积分
		User user2 = um.selectByPrimaryKey(user.getId());
		/*User user = um.selectByPrimaryKey(user);*/
		user2.setIntegral(user2.getIntegral()-gift.getIntegral());
		um.updateByPrimaryKey(user2);
	}
	
	
	
	
}

