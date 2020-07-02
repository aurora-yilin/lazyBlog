package com.mlw.lazyblog.controller.controllerExceptionHandler;

import com.mlw.lazyblog.common.enums.RegistExceptionEnum;
import com.mlw.lazyblog.common.enums.CommonEnum;
import com.mlw.lazyblog.common.vo.ResultVO;
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
        return new ResultVO(RegistExceptionEnum.MAIL.getCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(RedisGetException.class)
    public ResultVO redisGetExceptionHandle(RedisGetException e){
        return new ResultVO(RegistExceptionEnum.REDISGET.getCode(),e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(RedisSaveException.class)
    public ResultVO redisSaveExceptionHandle(RedisSaveException e){
        return new ResultVO(RegistExceptionEnum.REDISSAVE.getCode(),e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(DataAccessException.class)
    public ResultVO dataAccessExceptionHandle(DataAccessException e){
        return new ResultVO(CommonEnum.SQLE.getCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public ResultVO runtimeExceptionHandle(RuntimeException e){
        return new ResultVO(CommonEnum.ERROR.getCode(),e.getMessage());
    }
}
