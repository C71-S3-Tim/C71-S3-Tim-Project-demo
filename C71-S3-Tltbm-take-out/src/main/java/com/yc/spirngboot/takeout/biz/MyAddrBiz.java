package com.yc.spirngboot.takeout.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.Allotinf;
import com.yc.spirngboot.takeout.bean.AllotinfExample;
import com.yc.spirngboot.takeout.dao.AllotinfMapper;
import com.yc.spirngboot.takeout.dao.MyorderMapper;
import com.yc.spirngboot.takeout.vo.OrderAddr;

@Service
public class MyAddrBiz {
	@Resource
	private AllotinfMapper allm;
	
	
	//根据User_id查出addr
	public List<Allotinf> addr(int UserId){
		AllotinfExample example=new AllotinfExample();
		example.createCriteria().andUIdEqualTo(UserId);
		return allm.selectByExample(example);
	}
	
	//插入新地址
	public int addAddr(OrderAddr addr,int uid) {
		Allotinf allinf=new Allotinf();
		allinf.setAddr(addr.getDelivery_address());
		allinf.setMyrename(addr.getCustomer_name());
		allinf.setRephone(addr.getCustomer_phone());
		allinf.setuId(uid);
		allm.insert(allinf);
		return allinf.getId();
	}
	//修改地址
	public int  updateAddr(OrderAddr addr,int uid) {
		Allotinf allinf=new Allotinf();
		allinf.setAddr(addr.getDelivery_address());
		allinf.setMyrename(addr.getCustomer_name());
		allinf.setRephone(addr.getCustomer_phone());
		allinf.setuId(uid);
		allinf.setId(Integer.parseInt(addr.getId()));
		int clume=allm.updateByPrimaryKeySelective(allinf);
		return clume;
	}

	public int deletAddr(OrderAddr addr) {
		int clume=allm.deleteByPrimaryKey(Integer.parseInt(addr.getId()));
		return clume;
	}

}
