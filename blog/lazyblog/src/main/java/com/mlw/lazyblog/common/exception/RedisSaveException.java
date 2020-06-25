package com.mlw.lazyblog.common.exception;

/**
 * @author oRuol
 * @Date 2020/6/25 8:24
 */
public class RedisSaveException extends RuntimeException{
    public RedisSaveException() {
    }

    public RedisSaveException(String message) {
        super(message);
    }
}
