package com.yc.spirngboot.takeout.vo;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id ="2016101800717011";	
	
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEuwIBADANBgkqhkiG9w0BAQEFAASCBKUwggShAgEAAoIBAQCRNizj2Jh9Y/M2NFU0lgjMH6gCqt6uhJEFD5pP/4q/j8MkW2wjDYdqEDHh9C9xR4s064mXcXVVjQj+HGw1vAs1cMMIMPv5ztWzhfAwS7M/2ojAk9fJf793dkkC3N4/QNHBA4l0jQXfBbMns0MfzfuWhjS2h2bBEZhDbTsyz3iayYayAcfTu1A+G6c6UduGwFZk9Kqq1k1nub2A8J0W603g/n6iZJ/JpVu9L0zny89XQJ+V7AGm2Rczm98BK8/2uleAdFtleJfoLL/aJ8kWK3myakQQB9LkZ0SjI8Czok1TAS5oRtTz8PJtIltLPCFUcx2fd/qlUOSZ76+vGISZCh2TAgMBAAECgf9g/s79YrB5EUpj6pD/jzhRINQY9AnKiMJVnxZ0WT1Ut7Khlm+k+mR5dFfdlj4abK+PqcU+Y4r8mjhnhJTDT9gs2iVsU0v8kSwtvkmx+N7CyDaQbDC3Z519LoWWY/IQTjvNsY8fSxOg5S3GVvd/RxfGc97CDa+VRytt3oisZ+knenE7uzgtyrk7Zn9ed85AlpbFSDYPes2WAH4DOl2Wy4TD6sXKdci8y26eqj1K0z5gG0me0UXuy8FtZ8L1Q1+x2/2tEJu4waOdUc21k1lZgmkWj+Z/N7Xwbk+AGwXLGwK0FOUidbani1JJ1efsr+DWH4xwzm3pwrOzhhKjbBwMzgkCgYEA3rhoXtN/VubhgIYZrPlOseSNgdUYVuEsoZ5TxCgmtTi5QB7ob2l6J07dwrRoN3KljOQNKv9VfblwHzWj42nomSOi8Xrz29/ndA+QkZJ9Km+iU8HLXOXjwlEVysv8b7/eB3aLD4pk4BQAFzjD45ps+kXvbNNmTp3rFDke69d2GlcCgYEApujfGEsSM7DdvMG+qDwDGLx6phOVvwkWuQ5yXPMEzzXXJv9k3zzemZyVHnmnqA9/IhMF6/y+c7dPZW0tmkYbkiVXuZSjogbV4vPw9EIFf8URUAeya0eoj+WkYdh8PaxzGSWZkNfx6K47bNowrTlF75rflDptaGF7NuoBdZ3GySUCgYEArqZtMe8oLD1hGCgQelQGIfnX/bfdHkP1e8dsaKYTtIiGvIGAQ92yrKBrxgMytkhxCcrLiKwxniWMhuzJV8v1WiFX5YVFNWafWaPa+kylWmGwKX4OuwqLUBXFwQG1MuyCb9fFtKoR8KW+bHdXJWQzkQ7GcdBUqdGsRm+Ej+yl8IECgYBEG+zFpgSkcTzahJj/X5XH50mJMZ6+mL/b/ggu48AHqinEsR0Bd35CYsH68Ju4mbJAPlEBTl6NK7VLZzTfqlIf3fshMIVhXbaz6OVfVv2VeN4qsSleW5xuM8BTaRqxtAg3r78teuEtGMQJFDQey6s9Lg6kFv+EQ5sa+nxj+WEfvQKBgCuPtIeSu5uNTQprePr1XwRsBY6aPd0tW5j/jOzJp1kM6kW16RW6s2vi8rHKQop8O/dTdAzakR79i8mbqd3BYVKrTEE9HUFUs9HcJvw/JVmb0yLefmY3dTyYXRlraA5g+E5UhZJ6sXRZ2+4PJAPR/pI5n9aoHGzdb+Z0e4CpUzKt";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://127.0.0.1:8080/order_success.html";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://127.0.0.1:8080/order_success";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 日志存储盘符路径
	public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

