package com.yc.spirngboot.takeout.biz;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
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
	public Page<Comment> commentByPag() {
		
		Page<Comment> list=cmp.findByPaging(null);
		
		return list;
	}
	
}
