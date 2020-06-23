package com.mlw.lazyblog.common;

/**
 * @author oRuol
 * @Date 2020/6/23 19:08
 */
public enum  ResultCode {
    SUCCESS(200,"操作成功"),

    FAILED(400,"响应失败"),

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
