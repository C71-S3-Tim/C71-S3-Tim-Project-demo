import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.spirngboot.takeout.C71S3PljqSpringbootTakeoutApplication;
import com.yc.spirngboot.takeout.vo.CookieUtils;

@SpringBootTest(classes =C71S3PljqSpringbootTakeoutApplication.class)// 就是你springboot的启动类
public class testByCookie {
	
	
	@Test
	public void cookie(HttpServletRequest request,HttpServletResponse response) {
		// 创建一个 cookie对象
	    Cookie cookie = new Cookie("username", "Jovan");

	    //将cookie对象加入response响应
	    response.addCookie(cookie);
	    
		//CookieUtils myCookie=new CookieUtils();
	   // myCookie.writeCookie(response, "integal", "testText");
	    //String value=myCookie.getCookie(request, "integal");
	    System.out.println("value:"+cookie);
	}

}
