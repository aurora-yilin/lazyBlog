package com.mlw.lazyblog.config;

import com.mlw.lazyblog.interceptor.VerificationCodeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author oRuol
 * @Date 2020/6/24 21:09
 */
@Configuration
public class MyWebAppConfigure implements WebMvcConfigurer {

//    @Resource(name = "VerificationCodeInterceptor")
//    private VerificationCodeInterceptor verificationCodeInterceptor;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new VerificationCodeInterceptor())
//                .addPathPatterns();
//    }
}
