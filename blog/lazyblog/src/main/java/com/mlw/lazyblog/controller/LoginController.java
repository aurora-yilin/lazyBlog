package com.mlw.lazyblog.controller;

import com.mlw.lazyblog.entity.User;
import com.mlw.lazyblog.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author oRuol
 * @Date 2020/6/23 15:42
 */
@RestController
public class LoginController {
    @Resource
    private UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return "hello,lazyBlog";
    }

    @GetMapping("/user/{userName}")
    public User selectUser(@PathVariable("userName")String userName){
        return userService.selectUserByUserName(userName);
    }

}
