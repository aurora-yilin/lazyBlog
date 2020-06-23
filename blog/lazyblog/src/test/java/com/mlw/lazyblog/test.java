package com.mlw.lazyblog;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author oRuol
 * @Date 2020/6/23 20:02
 */
@SpringBootTest
public class test {

    @Test
    public void testEncode(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = bCryptPasswordEncoder.encode("admin");
        boolean admin = bCryptPasswordEncoder.matches("admin", "$2a$10$Es/Uylam3Q0iN2yVsg9aLeeksFXUfNX4MfnrtSTROIMwJa6gFnmni");
        System.out.println(admin);

        System.out.println(admin);
    }
}
