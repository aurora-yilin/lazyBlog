package com.mlw.lazyblog.common;

/**
 * @author oRuol
 * @Date 2020/6/23 19:08
 */
public enum  ResultCode {
    NOFILE(415,"没有检测到上传文件"),

    FAILTOFILE(417,"上传文件出错"),

    SQLE(413,"sql语句错误"),

    //邮件发送错误
    MAIL(401,""),

    //redis获取数据错误
    REDISGET(403,""),

    //redis存储数据错误
    REDISSAVE(406,""),

    //验证码错误
    VERCODE(408,"验证码错误"),

    //登陆后权限不足
    INSPER(409,"权限不足"),

    //未登录无权限
    NLOGIN(411,"未登录权限不足"),

    SUCCESS(200,"操作成功"),

    //登录失败
    FAILED(400,"登录失败"),

    VALIDATE_FAILED(1002,"参数校验失败"),

    ERROR(500,"未知错误");

    private int code;
    private String msg;

    ResultCode(int code,String msg){
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
