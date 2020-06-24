package com.mlw.lazyblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author oRuol
 * @Date 2020/6/24 10:48
 * redis实现session的共享
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfig {
}
