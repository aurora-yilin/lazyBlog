package com.mlw.lazyblog.controller;

import com.mlw.lazyblog.common.entity.User;
import com.mlw.lazyblog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author oRuol
 * @Date 2020/6/23 15:42
 */
@Slf4j
@RestController
public class LoginController {
    @Resource
    private UserService userService;

    @PostMapping("/hello")
    public String hello(@RequestParam("id")String id){
        log.info("id-----------"+id);
        return id;
    }

    @GetMapping("/user/{userName}")
    public User selectUser(@PathVariable("userName")String userName){
        return userService.selectUserByUserName(userName);
    }

}
