package com.yc.spirngboot.takeout.admin.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.Admin;
import com.yc.spirngboot.takeout.bean.AdminExample;
import com.yc.spirngboot.takeout.biz.BizExcption;
import com.yc.spirngboot.takeout.dao.AdminMapper;

@Service
public class AdminBiz {

	@Resource
	private AdminMapper admm;
	
	public Admin selectByUser(String admusername) throws BizExcption {
		System.out.println("aaaaaaaaa=" + admusername );
		
		AdminExample adminExample = new AdminExample();
		
		adminExample.createCriteria().andNameEqualTo(admusername);

		List<Admin> admins = admm.selectByExample(adminExample);
		if(admins.size()==1) {
			return admins.get(0);
		}else {
			throw new BizExcption("该管理员不存在！！！"); 
		}
	}
}
