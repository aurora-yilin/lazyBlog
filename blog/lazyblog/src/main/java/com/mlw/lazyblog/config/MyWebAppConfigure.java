package com.mlw.lazyblog.config;

import com.mlw.lazyblog.filter.CorsFilter;
import com.mlw.lazyblog.interceptor.VerificationCodeInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * 设置静态资源路径映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**")
                .addResourceLocations("file:D:/temporaryFiles/test/");
    }


    /**
     * cors配置
     * @param registry
     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry
//                .addMapping("/**")
//                .allowedOrigins("*")
//                .allowCredentials(true)
//                .allowedMethods("*")
//                .allowedHeaders("GET", "POST", "DELETE", "PUT")
//                .maxAge(3600);
//    }

    /**
     * 添加过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean SetCorsFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        CorsFilter corsFilter = new CorsFilter();

        filterRegistrationBean.setFilter(corsFilter);

        List<String> urls = new ArrayList<>();
        urls.add("/*");
        filterRegistrationBean.setUrlPatterns(urls);

        return filterRegistrationBean;
    }
}
