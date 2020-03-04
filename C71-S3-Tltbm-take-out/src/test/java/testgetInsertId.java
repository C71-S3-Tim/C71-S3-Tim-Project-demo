import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.spirngboot.takeout.C71S3PljqSpringbootTakeoutApplication;
import com.yc.spirngboot.takeout.bean.Allotinf;
import com.yc.spirngboot.takeout.bean.City;
import com.yc.spirngboot.takeout.bean.Myorder;
import com.yc.spirngboot.takeout.biz.UserBiz;
import com.yc.spirngboot.takeout.dao.AllotinfMapper;
import com.yc.spirngboot.takeout.dao.CityMapper;
import com.yc.spirngboot.takeout.dao.MyorderMapper;



@SpringBootTest(classes =C71S3PljqSpringbootTakeoutApplication.class)// 就是你springboot的启动类
public class testgetInsertId {
	@Resource
	private AllotinfMapper allm;
	
	//@Test
	public void testInsert() {
		Allotinf allinf=new Allotinf();
		allinf.setAddr("DASDASDS");
		allinf.setMyrename("测试");
		allinf.setRephone("测试电话");
		allinf.setuId(19);
		allm.insertSelective(allinf);
		int id=allinf.getId();
		System.out.println("id:"+id);
	}
	@Test
	public void testupdate() {
		Allotinf allinf=new Allotinf();
		allinf.setAddr("湖南长沙雨花区");
		allinf.setMyrename("测试");
		allinf.setRephone("测试电话110");
		allinf.setuId(19);
		allinf.setId(6);
		allm.updateByPrimaryKey(allinf);
		//int id=allinf.getId();
//		/System.out.println("id:"+id);
	}
}
