package com.mlw.lazyblog.common.enums;

/**
 * @author oRuol
 * @Date 2020/7/2 18:03
 */
public enum LoginExceptionEnum {
    //登陆后权限不足
    INSPER(409,"权限不足"),

    //未登录无权限
    NLOGIN(411,"未登录权限不足"),

    //登录失败
    FAILED(400,"登录失败");


    private int code;
    private String msg;

    LoginExceptionEnum(int code, String msg) {
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
