package com.mlw.lazyblog.component;

import com.mlw.lazyblog.common.exception.RedisGetException;
import com.mlw.lazyblog.common.exception.RedisSaveException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author oRuol
 * @Date 2020/6/24 20:10
 */
@Slf4j
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
        log.info("verification code:" + result);
        return result;
    }

    public void saveVerificationCode(String email,String verificationCode) throws RedisSaveException{
        try {
            redisTemplate.opsForValue()
                    .set(email, verificationCode, 10, TimeUnit.MINUTES);
        }catch (RuntimeException e){
            throw new RedisSaveException("验证码存储失败");
        }
    }

    public Object getVerificationCode(String email) throws RedisGetException{
        Object code = redisTemplate.opsForValue().get(email);
        if(code == null) {
            throw new RedisGetException("验证码获取失败");
        }
        else{
            return code;
        }
    }

    public Boolean delVerificationCode(String email){
        Boolean delete = redisTemplate.delete(email);
        return delete;
    }
}
