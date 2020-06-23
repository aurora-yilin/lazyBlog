package com.mlw.lazyblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author oRuol
 * @Date 2020/6/23 15:38
 */
@EnableAspectJAutoProxy
@EnableWebSecurity
@MapperScan("com.mlw.lazyblog.mypper")
@SpringBootApplication
public class LazyBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(LazyBlogApplication.class,args);
    }
}
