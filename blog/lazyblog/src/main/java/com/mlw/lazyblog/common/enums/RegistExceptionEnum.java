package com.mlw.lazyblog.common.enums;

/**
 * @author oRuol
 * @Date 2020/7/2 18:08
 */
public enum RegistExceptionEnum {
    //邮件发送错误
    MAIL(401,""),

    //redis获取数据错误
    REDISGET(403,""),

    //redis存储数据错误
    REDISSAVE(406,""),

    //验证码错误
    VERCODE(408,"验证码错误");

    private int code;
    private String msg;

    RegistExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
