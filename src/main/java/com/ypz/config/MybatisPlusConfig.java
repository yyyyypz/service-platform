package com.ypz.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis-Plus配置类
 */
@Configuration
public class MybatisPlusConfig {
    // mybatis-Plus拦截器，有了这个拦截器才能实现分页查询
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
