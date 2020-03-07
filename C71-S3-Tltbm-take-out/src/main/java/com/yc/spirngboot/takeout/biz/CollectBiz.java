package com.yc.spirngboot.takeout.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.Collect;
import com.yc.spirngboot.takeout.bean.CollectExample;
import com.yc.spirngboot.takeout.dao.CollectMapper;

@Service
public class CollectBiz {
	@Resource
	private CollectMapper cm;
	
	public List<Collect> selectCollect(int uid){
		CollectExample ce=new CollectExample();
		ce.createCriteria().andUIdEqualTo(uid);
		return  cm.selectByExample(ce);
	}
	//删除收藏店铺
	public void deletCollect(int parseInt) {
		CollectExample ce=new CollectExample();
		ce.createCriteria().andSIdEqualTo(parseInt);
		cm.deleteByExample(ce);
		
	}

}
