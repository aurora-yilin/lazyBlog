package com.mlw.lazyblog.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author oRuol
 * @Date 2020/6/24 19:46
 */
@Slf4j
@Component
public class EmailBuilder {

    @Resource
    private JavaMailSender javaMailSender;

    public void sendEmail(String receive,String content) throws MailException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("liyilinshui@foxmail.com");
        simpleMailMessage.setTo(receive);
        simpleMailMessage.setSubject("lazyBlog Verification code");
        simpleMailMessage.setText(content);
        javaMailSender.send(simpleMailMessage);
        log.info("send Email---------------"+receive);
    }
}
