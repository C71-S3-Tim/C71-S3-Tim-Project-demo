package com.yc.spirngboot.takeout.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.Orderinfo;
import com.yc.spirngboot.takeout.bean.OrderinfoExample;
import com.yc.spirngboot.takeout.dao.OrderinfoMapper;

@Service
public class OrderInfoBiz {
	@Resource
	private OrderinfoMapper ofm;
	//插入数据
	public void createinfo(String totalMoney, String order_number) {
		
		Orderinfo f=new Orderinfo();
		f.setMoney(Float.parseFloat(totalMoney));
		f.setOrdername(order_number);
		ofm.insert(f);
	}
	//查询订单
	public float selectMoney(String order_number) {
		OrderinfoExample ofe=new OrderinfoExample();
		ofe.createCriteria().andOrdernameEqualTo(order_number);
		List<Orderinfo> list=ofm.selectByExample(ofe);
		if(list!=null&&list.size()==1) {
			return list.get(0).getMoney();
		}else {
			return 0;
		}
		
	}

}
