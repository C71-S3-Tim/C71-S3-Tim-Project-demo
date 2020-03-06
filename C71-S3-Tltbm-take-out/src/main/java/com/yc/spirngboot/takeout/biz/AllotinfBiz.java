package com.yc.spirngboot.takeout.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.Allotinf;
import com.yc.spirngboot.takeout.bean.AllotinfExample;
import com.yc.spirngboot.takeout.dao.AllotinfMapper;

@Service
public class AllotinfBiz {
	@Resource
	private AllotinfMapper afm;
	
	
}
