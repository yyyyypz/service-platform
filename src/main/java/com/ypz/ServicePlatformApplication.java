package com.ypz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ypz.mapper")
public class ServicePlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicePlatformApplication.class, args);
    }

}
