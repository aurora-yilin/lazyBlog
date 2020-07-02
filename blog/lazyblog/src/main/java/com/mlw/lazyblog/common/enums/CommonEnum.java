package com.mlw.lazyblog.common.enums;

/**
 * @author oRuol
 * @Date 2020/6/23 19:08
 */
public enum CommonEnum {

    SQLE(413,"sql语句错误"),

    SUCCESS(200,"操作成功"),

    VALIDATE_FAILED(1002,"参数校验失败"),

    ERROR(500,"未知错误");

    private int code;
    private String msg;

    CommonEnum(int code, String msg){
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
