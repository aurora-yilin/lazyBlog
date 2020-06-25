package com.mlw.lazyblog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author oRuol
 * @Date 2020/6/23 20:02
 */
@SpringBootTest
public class test {

    @Resource
    private JavaMailSender javaMailSender;

    @Resource
    private RedisTemplate redisTemplate;

    @org.junit.jupiter.api.Test
    public void testEncode(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = bCryptPasswordEncoder.encode("admin");
        boolean admin = bCryptPasswordEncoder.matches("admin", "$2a$10$Es/Uylam3Q0iN2yVsg9aLeeksFXUfNX4MfnrtSTROIMwJa6gFnmni");
        System.out.println(admin);

        System.out.println(admin);
    }

    /**
     * Redis常见的五大数据类型
     * String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     *
     * 以下是spring操作Redis的工具方法：
     *      (StringRedisTemplate)stringRedisTemplate.opsForValue();[String（字符串）]
     *      (StringRedisTemplate)stringRedisTemplate.opsForHash();[Hash（散列）]
     *      (StringRedisTemplate)stringRedisTemplate.opsForList();[Hash（列表）]
     *      (StringRedisTemplate)stringRedisTemplate.opsForSet();[Hash（集合）]
     *      (StringRedisTemplate)stringRedisTemplate.opsForZSet();[Hash（有序集合）]
     */
    @Test
    public void testRedisTemplate(){
//        TestUser user = new TestUser();
//        user.setUserId(1);
//        user.setUserName("xiaoming");
//        user.setPassword("123456");
//        user.setMail("957197536@qq.com");
//        user.setUserAuthority("root");
        String user = "176183";
        redisTemplate.opsForValue().set("name",user);

        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);

    }

    @Test
    public void sendEmail(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("liyilinshui@foxmail.com");
        simpleMailMessage.setTo("2095147827@qq.com");
        simpleMailMessage.setSubject("lazyBlog Verification code");
        simpleMailMessage.setText("邮件测试服务");
        javaMailSender.send(simpleMailMessage);
    }

    @Test
    public void GenerationVC(){
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 6; i++)
        {
            result += random.nextInt(10);
        }
        System.out.println(result);
    }

    @Test
    public void testDelCode(){
        Boolean delete = redisTemplate.delete("2095147827@qq.com");
        System.out.println(delete);
    }
}
