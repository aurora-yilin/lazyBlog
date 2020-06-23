package com.mlw.lazyblog.service;

import com.mlw.lazyblog.entity.User;
import com.mlw.lazyblog.mypper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author oRuol
 * @Date 2020/6/23 16:11
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public User selectUserByUserName(String userName){
        return userMapper.selectUserByUserName(userName);
    }
}
