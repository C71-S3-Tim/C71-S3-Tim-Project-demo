package com.yc.spirngboot.takeout.biz;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.Dayandcount;
import com.yc.spirngboot.takeout.bean.Orderinfo;
import com.yc.spirngboot.takeout.bean.OrderinfoExample;
import com.yc.spirngboot.takeout.dao.OrderinfoMapper;

@Service
public class OrderInfoBiz {
	@Resource
	private OrderinfoMapper ofm;
	//插入数据
	public void createinfo(String totalMoney, String order_number,int sid) {
		
		Orderinfo f=new Orderinfo();
		f.setMoney(Float.parseFloat(totalMoney));
		f.setOrdername(order_number);
		f.setsId(sid);
		//设置支付状态
		f.setStatus(0);
		//设置时间
		Timestamp time = new Timestamp(System.currentTimeMillis());
		System.out.println("time========="+time);
		f.setCreatetime(time);
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
	//查询订单根据店铺
	public List<Orderinfo> selectBySeller_id(Integer id) {
		OrderinfoExample oe=new OrderinfoExample();
		oe.createCriteria().andSIdEqualTo(id);
		return ofm.selectByExample(oe);
	}
	//报表统计
	public List<Dayandcount> selectWeekAndCount(int s_id){
		List<Dayandcount> s=ofm.selectAndcount(s_id);
		System.out.println(s);
		return s;
	}
}
