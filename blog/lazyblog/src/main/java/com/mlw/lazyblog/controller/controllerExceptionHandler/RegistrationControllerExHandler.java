package com.mlw.lazyblog.controller.controllerExceptionHandler;

import com.mlw.lazyblog.common.ResultCode;
import com.mlw.lazyblog.common.ResultVO;
import com.mlw.lazyblog.common.exception.RedisGetException;
import com.mlw.lazyblog.common.exception.RedisSaveException;
import org.springframework.dao.DataAccessException;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author oRuol
 * @Date 2020/6/25 8:21
 */

@ControllerAdvice
public class RegistrationControllerExHandler {

    @ResponseBody
    @ExceptionHandler(MailException.class)
    public ResultVO mailExceptionHandle(MailException e){
        return new ResultVO(ResultCode.MAIL.getCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(RedisGetException.class)
    public ResultVO redisGetExceptionHandle(RedisGetException e){
        return new ResultVO(ResultCode.REDISGET.getCode(),e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(RedisSaveException.class)
    public ResultVO redisSaveExceptionHandle(RedisSaveException e){
        return new ResultVO(ResultCode.REDISSAVE.getCode(),e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(DataAccessException.class)
    public ResultVO dataAccessExceptionHandle(DataAccessException e){
        return new ResultVO(ResultCode.SQLE.getCode(), e.getMessage());
    }
}
