package com.mlw.lazyblog.service;

import com.mlw.lazyblog.common.entity.User;
import com.mlw.lazyblog.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author oRuol
 * @Date 2020/6/23 16:11
 */
@Slf4j
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public User selectUserByUserName(String userName){
        log.info("selectUserByUserName---------"+userName);
        return userMapper.selectUserByUserName(userName);
    }
    public int saveUser(User user) throws DataAccessException{
        try {
            log.info("saveUser----------"+user);
            return userMapper.saveUser(user);
        }catch (DataAccessException dae){
            throw dae;
        }
    }
}
