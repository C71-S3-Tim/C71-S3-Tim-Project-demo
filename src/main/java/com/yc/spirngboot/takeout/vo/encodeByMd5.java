package com.yc.spirngboot.takeout.vo;

import java.security.MessageDigest;

import Decoder.BASE64Encoder;

public class encodeByMd5 {
	
	public  String MD5(String encodeText){
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
}
	
