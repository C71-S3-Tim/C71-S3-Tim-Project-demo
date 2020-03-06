import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.spirngboot.takeout.C71S3PljqSpringbootTakeoutApplication;
import com.yc.spirngboot.takeout.bean.City;
import com.yc.spirngboot.takeout.bean.Myorder;
import com.yc.spirngboot.takeout.biz.UserBiz;
import com.yc.spirngboot.takeout.dao.CityMapper;
import com.yc.spirngboot.takeout.dao.MyorderMapper;



@SpringBootTest(classes =C71S3PljqSpringbootTakeoutApplication.class)// 就是你springboot的启动类
public class testintsertByUtf_8 {
	@Resource
	private  UserBiz ubiz;
	@Resource
	private MyorderMapper mom;
	@Resource
	private CityMapper  cm;
	
	//@Test
	public void testInsert() {
		City city=new City();
		city.setName("长沙");
		cm.insert(city);
	}
	@Test
	public void testinsertData() {
		
	//List<Order> orders=om.selectByExample(null);
	Myorder or=mom.selectByPrimaryKey(1);
		System.out.println(or);
		
		    
	}
	
}
