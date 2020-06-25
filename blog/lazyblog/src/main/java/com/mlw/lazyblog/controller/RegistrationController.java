package com.mlw.lazyblog.controller;

import com.mlw.lazyblog.common.ResultCode;
import com.mlw.lazyblog.common.ResultVO;
import com.mlw.lazyblog.common.exception.RedisGetException;
import com.mlw.lazyblog.common.exception.RedisSaveException;
import com.mlw.lazyblog.component.EmailBuilder;
import com.mlw.lazyblog.component.VerificationcodeBuilder;
import com.mlw.lazyblog.entity.User;
import com.mlw.lazyblog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author oRuol
 * @Date 2020/6/24 20:08
 */
@RestController
@Slf4j
public class RegistrationController {

    @Resource
    private UserService userService;

//    @Resource
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Resource
    private VerificationcodeBuilder verificationcodeBuilder;

    @Resource
    private EmailBuilder emailBuilder;

    @PostMapping("/sendemail")
    public ResultVO sendEmail(@RequestParam("email") String email){
        String vCode = verificationcodeBuilder.GenerationVerificationCode();
        try {
            verificationcodeBuilder.saveVerificationCode(email, vCode);
            emailBuilder.sendEmail(email, vCode);
        }catch (MailException me){
            throw me;
        }catch (RedisSaveException rse){
            throw rse;
        }
        return new ResultVO(ResultCode.SUCCESS);
    }

    @PostMapping("/regist")
    public ResultVO saveUser(User user, @RequestParam("code")String code){
        user.setUserAuthority("guest");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        try {
            String verificationCode = (String)verificationcodeBuilder.getVerificationCode(user.getEmail());
            if (code.equals(verificationCode)) {
                userService.saveUser(user);
                return new ResultVO(ResultCode.SUCCESS);
            } else {
                return new ResultVO(ResultCode.VERCODE);
            }
        }catch(RedisGetException rge){
            throw rge;
        }
        catch (RuntimeException re){
            throw re;
        }
    }
}
