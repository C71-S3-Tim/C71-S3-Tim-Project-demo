import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;

import Decoder.BASE64Encoder;

public class test {

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
		String code="123";
		String result=encodeByMd5(code);	
		System.out.println("code========="+code);
		System.out.println("result========="+result);		
	}
}
