package com.mlw.lazyblog.mapper;

import com.mlw.lazyblog.common.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

/**
 * @author oRuol
 * @Date 2020/6/23 15:52
 */
@Mapper
public interface UserMapper {
    public User selectUserByUserName(String userName);

    public int saveUser(@Param("user") User user)throws DataAccessException;
}
