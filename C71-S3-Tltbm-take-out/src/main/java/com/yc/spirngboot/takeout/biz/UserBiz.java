package com.yc.spirngboot.takeout.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.Collect;
import com.yc.spirngboot.takeout.bean.CollectExample;
import com.yc.spirngboot.takeout.bean.OrderinfoExample;
import com.yc.spirngboot.takeout.bean.OrderinfoExample.Criteria;
import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.bean.SellerExample;
import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.bean.UserExample;
import com.yc.spirngboot.takeout.dao.CollectMapper;
import com.yc.spirngboot.takeout.dao.OrderinfoMapper;
import com.yc.spirngboot.takeout.dao.SellerMapper;
import com.yc.spirngboot.takeout.dao.UserMapper;
import com.yc.spirngboot.takeout.vo.encodeByMd5;

@Service
public class UserBiz {
	@Resource
	private UserMapper um;
	@Resource
	private OrderinfoMapper oim;
	@Resource
	private SellerMapper sm;
	@Resource
	private CollectMapper cm;
	
	public void reg(User user) {
		//对密码进行md5加密
		encodeByMd5 md=new encodeByMd5();
		String newpwd=md.MD5(user.getPwd());
		user.setPwd(newpwd);
		//System.out.println(user);
 		um.insertSelective(user);
	}

	//用户登陆

	public User selectByUser(String phone) throws BizExcption {
		UserExample ue=new UserExample();

		ue.createCriteria().andPhoneEqualTo(phone);					

		List<User> users=um.selectByExample(ue);
		if(users.size()==1) {
			return users.get(0);
		}else {
			throw new BizExcption("用户不存在"); 
		}
	}

	//加入积分
	public void addIntegal(int intergal, Integer uid) {
		User user=um.selectByPrimaryKey(uid);
		user.setIntegral(user.getIntegral()+intergal);
		um.updateByPrimaryKey(user);
		
	}

	
	
	public void change(User user,String new_password) {
		
		encodeByMd5 md5=new encodeByMd5();
		String password=md5.MD5(new_password);
		
		user.setPwd(password);
		um.updateByPrimaryKeySelective(user);
		
	}
	
	//所有的订单数
	public int allorders() {
		OrderinfoExample example=new OrderinfoExample();
		int records=oim.selectByExample(null).size();
		return records;
	}
	
	
	//成功的订单数
	public int sucessorders() {
		OrderinfoExample example=new OrderinfoExample();
		Criteria Orders=example.createCriteria().andStatusEqualTo(0);
		int sucOrders=(int) oim.countByExample(example);
		return sucOrders;
	}

	
	
	//模糊查询餐厅
	public List<Seller> query(String name) {
		String sname=name.trim();
		SellerExample example=new SellerExample();
		example.createCriteria().andSnameLike("%"+sname+"%");
		List<Seller> list=sm.selectByExample(example);
		return list;
	}
	
	//热门店铺展示
	public List<Seller> hotquery(){
		SellerExample example=new SellerExample();
		example.createCriteria().andHotEqualTo(0);
		List<Seller> list=sm.selectByExample(example);
		return list;
	}

    //收藏餐厅
	public int collect(int seller_id,int user_id) {
	    CollectExample example=new CollectExample();
	    example.createCriteria().andSIdEqualTo(seller_id).andUIdEqualTo(user_id);
	    List<Collect> collect=cm.selectByExample(example);
		if(collect.size()<1){
			Collect ct=new Collect();
			ct.setuId(user_id);
			ct.setsId(seller_id);
			cm.insert(ct);
			return 0;
		}else {
			return 1;
		}
	}
	

}
