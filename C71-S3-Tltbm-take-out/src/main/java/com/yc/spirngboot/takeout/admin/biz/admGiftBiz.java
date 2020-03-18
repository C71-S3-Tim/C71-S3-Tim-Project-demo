package com.yc.spirngboot.takeout.admin.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.Gift;
import com.yc.spirngboot.takeout.dao.GiftMapper;

@Service
public class admGiftBiz {

	@Resource
	private GiftMapper admgm;
	
	//新增
	public void addgift(String formdata,  Gift gift) {
		
		gift.setImage("images/gift/"+formdata);
		
		admgm.insert(gift);
	}
	
	
	//删除
	public void delegift(Integer gid) {
		
		admgm.deleteByPrimaryKey(gid);
	}
	
	
	//修改
	public void updataift(Integer gid, Gift gift) {
		
		System.out.println("===========" + gid);
		
		admgm.updateByPrimaryKey(gift);
	}
}
