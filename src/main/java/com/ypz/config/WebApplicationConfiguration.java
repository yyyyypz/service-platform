package com.ypz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebApplicationConfiguration implements WebMvcConfigurer {
    // 静态资源映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 轮播图图片路径映射
        registry.addResourceHandler("/images/swiper/**").addResourceLocations("file:D:\\service-platform-resources\\swiperImages\\");
        // 商品大类图片路径映射
        registry.addResourceHandler("/images/bigType/**").addResourceLocations("file:D:\\service-platform-resources\\bigTypeImages\\");
    }
}
