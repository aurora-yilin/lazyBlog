package com.mlw.lazyblog.common.exception;

/**
 * @author oRuol
 * @Date 2020/6/25 8:26
 */
public class RedisGetException extends RuntimeException{
    public RedisGetException() {
    }

    public RedisGetException(String message) {
        super(message);
    }
}
