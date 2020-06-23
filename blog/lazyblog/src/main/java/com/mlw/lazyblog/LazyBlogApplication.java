package com.mlw.lazyblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author oRuol
 * @Date 2020/6/23 15:38
 */
@MapperScan("com.mlw.lazyblog.mypper")
@SpringBootApplication
public class LazyBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(LazyBlogApplication.class,args);
    }
}
