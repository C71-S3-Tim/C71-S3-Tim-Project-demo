package com.yc.spirngboot.takeout.biz;

import java.sql.Timestamp;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.Collect;
import com.yc.spirngboot.takeout.bean.CollectExample;
import com.yc.spirngboot.takeout.bean.Comment;
import com.yc.spirngboot.takeout.bean.CommentExample;
import com.yc.spirngboot.takeout.bean.Orderinfo;
import com.yc.spirngboot.takeout.bean.OrderinfoExample;
import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.bean.SellerExample;
import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.bean.UserExample;
import com.yc.spirngboot.takeout.dao.CollectMapper;
import com.yc.spirngboot.takeout.dao.CommentMapper;
import com.yc.spirngboot.takeout.dao.OrderinfoMapper;
import com.yc.spirngboot.takeout.dao.SellerMapper;
import com.yc.spirngboot.takeout.vo.encodeByMd5;

@Service
public class BackSellerBiz {

	@Resource
	private SellerMapper sm;
	@Resource
	private CommentMapper cm;
	@Resource
	private CollectMapper ctm;
	@Resource
	private OrderinfoMapper oim;
	
	public void reg(Seller seller) {
		//对密码进行md5加密
		encodeByMd5 md=new encodeByMd5();
		String newpwd=md.MD5(seller.getSpwd());
		seller.setSpwd(newpwd);
		sm.insertSelective(seller);
	}
	
	//商家登录
	public Seller selectBySeller(String sphone) throws BizExcption {
		SellerExample example=new SellerExample();
		example.createCriteria().andSphoneEqualTo(sphone);

		List<Seller> sellers=sm.selectByExample(example);
		if(sellers.size()==1) {
			return sellers.get(0);
		}else {
			throw new BizExcption("商家不存在"); 
		}
	}
	
	//店铺总评论数
	public int comment(int s_id) {
		CommentExample example=new CommentExample();
		example.createCriteria().andSIdEqualTo(s_id);
		List<Comment> comment=cm.selectByExample(example);
		int allcomments=comment.size();
		return allcomments;
	}
	
	//店铺今日评论数
	public int Todaycomment(int s_id) {
		long current=System.currentTimeMillis();//当前时间毫秒数
		long zero=current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
		Timestamp time=new Timestamp(zero);
		System.out.println(time);//今天零点零分零秒
		
		CommentExample example=new CommentExample();
		example.createCriteria().andSIdEqualTo(s_id).andCreatetimeGreaterThan(time);
		List<Comment> comment=cm.selectByExample(example);
		int todaycomments=comment.size();
		return todaycomments;
	}
	
	//收藏店铺粉丝数
	public int collect(int s_id) {
		CollectExample example=new CollectExample();
		example.createCriteria().andSIdEqualTo(s_id);
		List<Collect> collect=ctm.selectByExample(example);
		int collects=collect.size();
		return collects;
	}
	
	//店铺总订单数
		public int orders(int s_id) {
			OrderinfoExample example=new OrderinfoExample();
			example.createCriteria().andSIdEqualTo(s_id).andStatusEqualTo(0);
			List<Orderinfo> orderinfo=oim.selectByExample(example);
			int orders=orderinfo.size();
			return orders;
		}
		
		//店铺今日订单数
		public int TodayOrders(int s_id) {
			long current=System.currentTimeMillis();//当前时间毫秒数
			long zero=current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
			Timestamp time=new Timestamp(zero);   //今天零点零分零秒
			System.out.println(time);
			
			OrderinfoExample example=new OrderinfoExample();
			example.createCriteria().andSIdEqualTo(s_id).andCreatetimeGreaterThan(time).andStatusEqualTo(0);
			List<Orderinfo> todayorderinfo=oim.selectByExample(example);
			int todayorders=todayorderinfo.size();
			return todayorders;
		}
	

		//店铺带支付订单数
			public int NeedOrders(int s_id) {
				OrderinfoExample example=new OrderinfoExample();
				example.createCriteria().andSIdEqualTo(s_id).andStatusEqualTo(1);
				List<Orderinfo> orderinfo=oim.selectByExample(example);
				int needorders=orderinfo.size();
				return needorders;
			}
			//店铺下单数
			public int order(int s_id) {
				OrderinfoExample example=new OrderinfoExample();
				example.createCriteria().andSIdEqualTo(s_id);
				List<Orderinfo> orderinfo=oim.selectByExample(example);
				int order=orderinfo.size();
				return order;
			}
			
			//店铺收益
			public int money(int s_id) {
				OrderinfoExample example=new OrderinfoExample();
				example.createCriteria().andSIdEqualTo(s_id);
				List<Orderinfo> orderinfo=oim.selectByExample(example);
				int money = 0;
				for(int i=0;i<orderinfo.size();i++) {
					money+=orderinfo.get(i).getMoney();	
				}
				return money;
			}
}
