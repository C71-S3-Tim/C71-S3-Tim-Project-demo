package com.yc.spirngboot.takeout.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.dao.SellerMapper;

@Service
public class SellerBiz {
	@Resource
	private SellerMapper sm;
	
	
	public String selectnameByKey(int seller_id) {
		Seller s=sm.selectByPrimaryKey(seller_id);
		return s.getSname();
	}
	//
	public Seller selectById(int seller_id) {
		Seller s=sm.selectByPrimaryKey(seller_id);
		return s;
	}
}
