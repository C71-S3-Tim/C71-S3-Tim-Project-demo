package com.yc.spirngboot.takeout.admin.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yc.spirngboot.takeout.admin.biz.admGiftBiz;
import com.yc.spirngboot.takeout.bean.Gift;
import com.yc.spirngboot.takeout.bean.Giftorder;
import com.yc.spirngboot.takeout.dao.GiftMapper;
import com.yc.spirngboot.takeout.dao.GiftorderMapper;
import com.yc.spirngboot.takeout.vo.Result;

@Controller
public class admGiftAction {

	@Resource
	private GiftMapper admgm;
	
	@GetMapping("admin/gift.do")
	public String index(Model m) {
		List<Gift> giftlist = admgm.selectByExample(null);
		m.addAttribute("giftlist", giftlist);
		return "admin/Giftslist";
	}
	
	@Resource
	private GiftorderMapper admgom;
	
	@GetMapping("admin/buygift.do")
	public String buygiftlist(Model m) {
		List<Giftorder> buygiftlist = admgom.selectByExample(null);
		
		m.addAttribute("buygiftlist", buygiftlist);
		m.addAttribute("listsize", buygiftlist.size());
		return "admin/buygiftlist";
	}
	
	@GetMapping("admin/addgift.do")
	public String addgift(Model m) {
		return "admin/addgift";
	}
	
	@Resource
	private admGiftBiz admgbiz;
	
	//新增
	@PostMapping("admin/toaddgifts")
	@ResponseBody
	public Result toadd(@RequestParam("file") MultipartFile pPicture, String formdata,  Gift gift, Model m) throws IOException {
		
		Result result=new Result();
		
		String fileName = UUID.randomUUID()+ pPicture.getOriginalFilename();
		System.out.println(fileName);
		if(!pPicture.isEmpty()){
	        byte [] bytes = pPicture.getBytes();
	        BufferedOutputStream bufferedOutputStream = new
	                BufferedOutputStream(new FileOutputStream(new File("E:\\giftupload\\"+fileName)));
	        bufferedOutputStream.write(bytes);
	        bufferedOutputStream.close();
	        
	        System.out.println(bufferedOutputStream);
	    }
	    result.setData(gift);
		result.setCode(0);
		admgbiz.addgift(fileName,  gift);
			
		return result;
	}
	
	
	//删除
	@PostMapping("admin/deletegift.do")
	@ResponseBody
	public Result deleteseller(Integer gid) {
		Result result=new Result();
		if(gid!=null) {
			
			admgbiz.delegift(gid);
			result.setCode(0);
			result.setMsg("操作成功！");
		}else {
			result.setCode(1);
			result.setMsg("业务繁忙！");
		}
		return result;
	}
	
	//修改
	@PostMapping("admin/updatagift")
	@ResponseBody
	public Result updatagift(@RequestParam("file") MultipartFile pPicture, Integer gid, String name, Integer integral, Float value, Integer number,  Gift gift, Model m) {
		
		
		System.out.println("++++++++++++" + name);
		Result result=new Result();
		
		String fileName = UUID.randomUUID()+ pPicture.getOriginalFilename();
		System.out.println(fileName);
		try {
			if(!pPicture.isEmpty()){
		        byte [] bytes = pPicture.getBytes();
		        BufferedOutputStream bufferedOutputStream = new
		                BufferedOutputStream(new FileOutputStream(new File("E:\\giftupload\\"+fileName)));
		        bufferedOutputStream.write(bytes);
		        bufferedOutputStream.close();
		        String path="/images/gift/"+fileName;
		        System.out.println(path);
		        gift.setImage(path);
		    }
		} catch (IOException e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMsg("文件上传失败！");
			return result;
		}
		gift.setId(gid);
		gift.setIntegral(integral);
		gift.setName(name);
		gift.setNumber(number);
		gift.setValue(value);
		System.out.println(gift);
		
		try {
			admgbiz.updataift(gid, gift);
			result.setCode(0);
			result.setMsg("修改成功！");
		}catch (Exception e) {
			result.setCode(1);
			result.setMsg("系统繁忙请稍后再试！");
		}
		
		return result;
		
		
	}
	
}
