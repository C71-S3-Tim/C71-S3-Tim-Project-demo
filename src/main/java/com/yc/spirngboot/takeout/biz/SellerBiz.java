package com.yc.spirngboot.takeout.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.bean.SellerExample;
import com.yc.spirngboot.takeout.dao.SellerMapper;

@Service
public class SellerBiz {


	@Resource
	 private SellerMapper sm;



	public Seller selectById(Integer seller_id) {
		Seller s=sm.selectByPrimaryKey(seller_id);
		return s;
	}
}
