package com.yc.spirngboot.takeout.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.Allotinf;
import com.yc.spirngboot.takeout.bean.Gift;
import com.yc.spirngboot.takeout.dao.AllotinfMapper;
import com.yc.spirngboot.takeout.dao.GiftMapper;

@Service
public class GiftsBiz {

	@Resource
	private GiftMapper gm;
	
	@Resource
	private AllotinfMapper am;
	
	public void buygift(Gift gift, Allotinf allotinf) {
		
		Integer name = gift.getId();
		System.out.println("name=" + name);
		
		Integer uid = 21;
		allotinf.setuId(uid);
		
		//获取礼品数量
		am.insert(allotinf);
		
	}
	
	
	
	
}
