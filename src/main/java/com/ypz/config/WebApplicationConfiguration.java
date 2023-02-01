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
        // 热卖商品图片路径映射
        registry.addResourceHandler("/images/hotProduct/**").addResourceLocations("file:D:\\service-platform-resources\\productImages\\");
        // 商品详情图片路径映射
        registry.addResourceHandler("/images/productSwiperImages/**").addResourceLocations("file:D:\\service-platform-resources\\productSwiperImages\\");
        // 商品详情介绍图片路径映射
        registry.addResourceHandler("/images/productIntroImgs/**").addResourceLocations("file:D:\\service-platform-resources\\productIntroImgs\\");
        // 商品详情规格图片路径映射
        registry.addResourceHandler("/images/productParaImgs/**").addResourceLocations("file:D:\\service-platform-resources\\productParaImgs\\");
    }
}
