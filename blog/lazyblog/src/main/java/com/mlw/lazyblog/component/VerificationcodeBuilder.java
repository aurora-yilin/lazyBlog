package com.mlw.lazyblog.component;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author oRuol
 * @Date 2020/6/24 20:10
 */
@Component
public class VerificationcodeBuilder {

    @Resource
    private RedisTemplate redisTemplate;

    public String GenerationVerificationCode(){
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 6; i++)
        {
            result += random.nextInt(10);
        }
        return result;
    }

    public void saveVerificationCode(String email,String verificationCode){
        redisTemplate.opsForValue()
                .set(email,verificationCode,10, TimeUnit.MINUTES);
    }
}
