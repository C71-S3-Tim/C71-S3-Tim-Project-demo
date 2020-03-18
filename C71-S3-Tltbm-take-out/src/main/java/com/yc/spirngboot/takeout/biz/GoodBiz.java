package com.yc.spirngboot.takeout.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.Good;
import com.yc.spirngboot.takeout.bean.GoodExample;
import com.yc.spirngboot.takeout.dao.GoodMapper;

@Service
public class GoodBiz {
	@Resource
	private GoodMapper gmp;
	
	public Good selectById(int gid) throws BizExcption {
		if(gid>0) {
			return gmp.selectByPrimaryKey(gid);
		}else {
			
			throw new BizExcption("非法数据");
		}
		
	}
	//由gid返回seller_id
		public int SelectSeller_idByGid(int gid) throws BizExcption {
			Good g=selectById(gid);
			return g.getSellerId();
		}
		
		//删除指定商品
		public void deleteById(int id) {
			gmp.deleteByPrimaryKey(id);
		}
		//update
		public void updateGood(Good g) {
			
			gmp.updateByPrimaryKeySelective(g);
			
		}
		//add
		public void addGood(Good g) {
			gmp.insert(g);
			
		}
		//数量变化
		public void updateGoodNumber(Good good) {
			gmp.updateByPrimaryKeySelective(good);
			
		}
}
