import java.security.MessageDigest;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.spirngboot.takeout.C71S3PljqSpringbootTakeoutApplication;
<<<<<<< HEAD
import com.yc.spirngboot.takeout.bean.Dayandcount;
=======
import com.yc.spirngboot.takeout.bean.Seller;
>>>>>>> branch 'master' of https://github.com/C71-S3-Tim/C71-S3-Tim-Project-demo.git
import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.biz.BackSellerBiz;
import com.yc.spirngboot.takeout.biz.UserBiz;
import com.yc.spirngboot.takeout.dao.OrderinfoMapper;
import com.yc.spirngboot.takeout.dao.UserMapper;
import Decoder.BASE64Encoder;

@SpringBootTest(classes =C71S3PljqSpringbootTakeoutApplication.class)// 就是你springboot的启动类
public class test {
	@Resource
	private  UserBiz ubiz;
	@Resource
	private UserMapper um;
	@Resource
<<<<<<< HEAD
	private  OrderinfoMapper om;
=======
	private BackSellerBiz bsbiz;
>>>>>>> branch 'master' of https://github.com/C71-S3-Tim/C71-S3-Tim-Project-demo.git
	
	public  String encodeByMd5(String encodeText){
		try{
		//创建md5的加密方式
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		//使用md5方式对输入值进行加密
		byte[] encodeData = messageDigest.digest(encodeText.getBytes("utf-8"));
		//使用BASE64Encoder的encode方法，把字节数组转成字符串
		String result=new BASE64Encoder().encode(encodeData);
		return result;
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
}
	@Test
	public void testencodeByMd5() {
		User user =new User();
		user.setPhone("13135187907");
		user.setPwd("123456");
		user.setcId(null);
		
		
		ubiz.reg(user);
		
		String code="123";
		String result=encodeByMd5(code);	
		System.out.println("code========="+code);
		System.out.println("result========="+result);
		//ICy5YqxZB1uWSwcVLSNLcA
	}
	
	@Test
	public void SellercodeByMd5() {
		Seller seller=new Seller();
		seller.setSphone("13135187907");
		seller.setSpwd("123456");

	
		bsbiz.reg(seller);
		
		String code="123";
		String result=encodeByMd5(code);	
		System.out.println("code========="+code);
		System.out.println("result========="+result);
		//ICy5YqxZB1uWSwcVLSNLcA
	}
	
	@Test
	public void testUpdate(String newpwd ,User user) {
		
		String result=encodeByMd5(newpwd);
		user.setPwd(result);
		
		um.updateByPrimaryKeySelective(user);
		
		User us=new User();
		us.setId(18);
		us.setPwd("888888");
		us.setPhone("13135187907");
		um.updateByPrimaryKeySelective(us);
		
	}
	@Test
	public void testweek() {
		List<Dayandcount> s=om.selectAndcount(1);
		System.out.println(s);
	}
	
	
}
