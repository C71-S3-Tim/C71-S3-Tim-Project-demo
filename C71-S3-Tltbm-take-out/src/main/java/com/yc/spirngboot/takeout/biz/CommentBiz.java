package com.yc.spirngboot.takeout.biz;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.spirngboot.takeout.bean.Comment;
import com.yc.spirngboot.takeout.dao.CommentMapper;

@Service
public class CommentBiz {
@Resource
private CommentMapper cmp;	

public void  addComment(String seller_id,String text,int uid) {
	Comment comment=new Comment();
	comment.setContent(text);
	comment.setsId(Integer.parseInt(seller_id));
	comment.setuId(uid);

	Timestamp time1 = new Timestamp(System.currentTimeMillis());
	System.out.println(time1);
	comment.setCreatetime(time1);
	cmp.insert(comment);
}
	
//创建订单时间
		public Date creatTiem() {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	 		String time = LocalDateTime.now().format(formatter);
	 		
	 		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
	 		java.sql.Date sDate = null;
	        try {
	            java.util.Date date3 = sdf2.parse(time);
	            sDate = new java.sql.Date(date3.getTime());
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return sDate;
		}
}
