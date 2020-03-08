package com.yc.spirngboot.takeout.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.City;
import com.yc.spirngboot.takeout.bean.CityExample;
import com.yc.spirngboot.takeout.bean.District;
import com.yc.spirngboot.takeout.bean.DistrictExample;
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
		
		//根据输入city查表
		CityExample citys = new CityExample();
		citys.createCriteria().andNameEqualTo(newcity);
		List<City> allcity = cm.selectByExample(citys);
		
		//根据输入district查表
		DistrictExample districts = new DistrictExample();
		districts.createCriteria().andDnameEqualTo(newdistrict);
		List<District> alldistrict = dm.selectByExample(districts);
		
		if(allcity.size()==0) { //如表内有输入city只获取id
			cm.insert(city);
			
			if(alldistrict.size()==0) {//如表内有输入city只获取id
				CityExample cityExample = new CityExample();
				cityExample.createCriteria().andNameEqualTo(newcity);
				City city2 = cm.selectByExample(cityExample).get(0);
				
				Integer cid = city2.getId();
				district.setCityId(cid);
				dm.insert(district);
			}else {
				System.out.println("dsadasda");
			}
			
		}else {
			City onecity = cm.selectByExample(citys).get(0);
			if(alldistrict.size()==0) {
				district.setCityId(onecity.getId());
				dm.insert(district);
			}else {
				System.out.println("12312412");
			}
		}
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
