package com.yc.spirngboot.takeout.biz;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpCookie;
import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.Coupon;
import com.yc.spirngboot.takeout.bean.Good;
import com.yc.spirngboot.takeout.bean.Myorder;
import com.yc.spirngboot.takeout.bean.MyorderExample;
import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.dao.MyorderMapper;
import com.yc.spirngboot.takeout.dao.SellerMapper;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

@Service
public class OrderBiz {
	@Resource
	private MyorderMapper mom;
	
	@Resource
	private SellerMapper sem;
	
	//创建订单数据 插入数据库
	public void  createOrder(Good good,String seller_id,int munber,String orderCode,int sendtime,Date  createDate) {
		Myorder myorder=new Myorder();
		myorder.setgId(good.getId());
		myorder.setMoney(good.getPrice());
		myorder.setNumber(munber);
		myorder.setOrdercode(orderCode);
		myorder.setSendtime(sendtime);
		myorder.setTime(createDate);
		mom.insert(myorder);
	}
	//由商品编号查出订单
	public List<Myorder> selectByOrder_number(String order_number) {
		MyorderExample moe=new MyorderExample();
		moe.createCriteria().andOrdercodeEqualTo(order_number);
		return mom.selectByExample(moe);
		
	}
	//计算过商品总价格 不包含包装费
	public int  tatoalmMoney(List<Myorder> orders,Coupon coupone) {
		
		int tatoalmMoney=0;
		for(Myorder m:orders) {
			tatoalmMoney+=m.getNumber()*m.getMoney();
		}
		if(coupone!=null) {
			//无门槛的情况
			if(coupone.getStatus()==0){
			tatoalmMoney+=coupone.getDiscount();
			//满减的情况
			}else if(tatoalmMoney>=coupone.getStatus()) {
				tatoalmMoney+=coupone.getDiscount();
				/**
				 * 这里因为数据库设计的的关系有bug
				 * 数据库中 user 与coupone应该为多对多的关系但是因为没有中间表导致次bug
				 * 一个用户可以无线使用同一张优惠券且只有一个优惠券
				 */
			}
		}
		return tatoalmMoney;
	}
	
}
