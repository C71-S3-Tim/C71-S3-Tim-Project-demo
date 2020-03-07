package com.yc.spirngboot.takeout.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.City;
import com.yc.spirngboot.takeout.bean.CityExample;
import com.yc.spirngboot.takeout.bean.District;
import com.yc.spirngboot.takeout.bean.Seller;
import com.yc.spirngboot.takeout.dao.CityMapper;
import com.yc.spirngboot.takeout.dao.DistrictMapper;
import com.yc.spirngboot.takeout.dao.SellerMapper;

@Service
public class IndexBiz {

	@Resource
	private SellerMapper sm;
	
	@Resource
	private CityMapper cm;
	
	@Resource
	private DistrictMapper dm;
	
	public void cityanddist(City city, District district) {
		//加入城市
		String newcity = city.getName();
		String newdistrict = district.getDname();
		System.out.println("newdistrict=" + newdistrict + "newcity=" + newcity);
			
		cm.insert(city);
		
		CityExample cityExample = new CityExample();
		cityExample.createCriteria().andNameEqualTo(newcity);
		City city2 = cm.selectByExample(cityExample).get(0);
		
		Integer cid = city2.getId();
		System.out.println(cid);
		district.setCityId(cid);
		
		System.out.println("城市" + city.getName());
		System.out.println("地区" + district.getDname());
		
		dm.insert(district);
		
		
	}
	
	
	public void newseller(Seller seller, City city) {
		String city1 = city.getName();
		
		CityExample cityExample = new CityExample();
		cityExample.createCriteria().andNameEqualTo(city1);
		City city2 = cm.selectByExample(cityExample).get(0);
		Integer cid = city2.getId();
		seller.setCityId(cid);
		
		//默认店铺状态
		Integer qualified = 0;
		seller.setQualified(qualified);

		sm.insert(seller);
	}
}
