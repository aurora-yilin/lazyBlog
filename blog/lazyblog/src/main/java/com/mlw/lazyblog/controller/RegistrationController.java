package com.mlw.lazyblog.controller;

import com.mlw.lazyblog.common.ResultCode;
import com.mlw.lazyblog.common.ResultVO;
import com.mlw.lazyblog.component.EmailBuilder;
import com.mlw.lazyblog.component.VerificationcodeBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author oRuol
 * @Date 2020/6/24 20:08
 */
@RestController
public class RegistrationController {

    @Resource
    private VerificationcodeBuilder verificationcodeBuilder;

    @Resource
    private EmailBuilder emailBuilder;

    @PostMapping("/sendemail")
    public ResultVO sendEmail(@RequestParam("email") String email){
        String vCode = verificationcodeBuilder.GenerationVerificationCode();
        verificationcodeBuilder.saveVerificationCode(email,vCode);
        emailBuilder.sendEmail(email,vCode);

        return new ResultVO(ResultCode.SUCCESS);
    }
}
