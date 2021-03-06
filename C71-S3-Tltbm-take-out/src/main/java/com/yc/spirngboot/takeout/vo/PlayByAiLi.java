package com.yc.spirngboot.takeout.vo;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.yc.spirngboot.takeout.vo.AlipayConfig;

@Service
public class PlayByAiLi {
	
	public String ali(String order_number,String money,String sellername) throws AlipayApiException, IOException{ 
		  //获得初始化的AlipayClient
		  AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		  //设置请求参数
		  AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();
		  aliPayRequest.setReturnUrl(AlipayConfig.return_url);
		  aliPayRequest.setNotifyUrl(AlipayConfig.notify_url);
		  
		  //商户订单号，后台可以写一个工具类生成一个订单号，必填
		  
		  //付款金额，从前台获取，必填
		  String total_amount = new String(money);
		  //订单名称，必填
		  String subject = new String(sellername);
		  aliPayRequest.setBizContent("{\"out_trade_no\":\"" + order_number + "\","
		    + "\"total_amount\":\"" + total_amount + "\","
		    + "\"subject\":\"" + subject + "\","
		    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		  //请求
		  String result = alipayClient.pageExecute(aliPayRequest).getBody();
		  //输出
		  return result;
		}
	
	
}
