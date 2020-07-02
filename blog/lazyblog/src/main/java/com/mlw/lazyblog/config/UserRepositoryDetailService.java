package com.mlw.lazyblog.config;

import com.mlw.lazyblog.common.entity.User;
import com.mlw.lazyblog.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author oRuol
 * @Date 2020/6/23 18:56
 */
@Slf4j
@Component
public class UserRepositoryDetailService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info(username+"----");
        User user = userMapper.selectUserByUserName(username);
        if(user != null){
            return user;
        }
        else{
            throw new UsernameNotFoundException("user" + username + "not fond");
        }
    }
}
