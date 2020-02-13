import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.spirngboot.takeout.C71S3PljqSpringbootTakeoutApplication;
import com.yc.spirngboot.takeout.bean.User;
import com.yc.spirngboot.takeout.biz.UserBiz;

import Decoder.BASE64Encoder;


@SpringBootTest(classes =C71S3PljqSpringbootTakeoutApplication.class)// 就是你springboot的启动类
public class test {
	@Resource
	private  UserBiz ubiz;
	
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
		
		ubiz.reg(user);
		
		String code="123";
		String result=encodeByMd5(code);	
		System.out.println("code========="+code);
		System.out.println("result========="+result);
		//ICy5YqxZB1uWSwcVLSNLcA
	}
}
