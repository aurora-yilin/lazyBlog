package com.mlw.lazyblog.mypper;

import com.mlw.lazyblog.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author oRuol
 * @Date 2020/6/23 15:52
 */
@Mapper
public interface UserMapper {
    public User selectUserByUserName(String userName);
}
