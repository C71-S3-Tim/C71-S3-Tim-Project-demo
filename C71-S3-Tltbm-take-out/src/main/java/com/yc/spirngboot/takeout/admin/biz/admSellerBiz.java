package com.yc.spirngboot.takeout.admin.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.dao.SellerMapper;

@Service
public class admSellerBiz {

	/* 表单删除*/
	@Resource
	private SellerMapper admsm;
	
	public void deleteseller(Integer sid) {
		admsm.deleteByPrimaryKey(sid);
	}
	
	/* 审核通过*/
	public void agreeseller(Integer sid) {
		
		Seller seller = admsm.selectByPrimaryKey(sid);
		Integer newzt = 0;
		
		seller.setQualified(newzt);
		
		admsm.updateByPrimaryKey(seller);
	}
	
	
	/* 暂停营业 */
	public void disagreeseller(Integer sid) {
		
		Seller seller = admsm.selectByPrimaryKey(sid);
		Integer newzt = 2;
		
		seller.setQualified(newzt);
		
		admsm.updateByPrimaryKey(seller);
	}
}
