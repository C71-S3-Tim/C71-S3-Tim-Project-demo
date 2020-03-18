package com.yc.spirngboot.takeout.vo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//文件上传的文件映射
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/good/**").addResourceLocations("file:E://upload/");
        registry.addResourceHandler( "/images/gift/**").addResourceLocations("file:E://giftupload/");
    }
}