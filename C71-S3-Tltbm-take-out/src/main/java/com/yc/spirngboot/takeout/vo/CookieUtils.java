package com.yc.spirngboot.takeout.vo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 将数据写入Cookie 中 因为支付包沙箱支付跳转通知页面的时候存入ssesion
 * 的对象无法获取到了
 */
public class CookieUtils {

    public  String getCookie(HttpServletRequest request,String cookieName){

        Cookie[] cookies =  request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(cookieName)){
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    public void writeCookie(HttpServletResponse response, String cookieName,String value){
        Cookie cookie = new Cookie(cookieName,value);
        	cookie.setPath("/");
        	cookie.setMaxAge(24*3600);
        response.addCookie(cookie);
    }

}

