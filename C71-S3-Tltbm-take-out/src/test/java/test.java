import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.spirngboot.takeout.C71S3PljqSpringbootTakeoutApplication;
import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.biz.UserBiz;
import com.yc.spirngboot.takeout.dao.UserMapper;

import Decoder.BASE64Encoder;


@SpringBootTest(classes =C71S3PljqSpringbootTakeoutApplication.class)// 就是你springboot的启动类
public class test {
	@Resource
	private  UserBiz ubiz;
	@Resource
	private UserMapper um;
	
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
	
	
	
	
}
