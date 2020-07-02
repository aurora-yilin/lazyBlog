package com.mlw.lazyblog.common.enums;

/**
 * @author oRuol
 * @Date 2020/7/2 17:59
 */
public enum FileExceptionEnum {
    NOFILE(415,"没有检测到上传文件"),

    FAILTOFILE(417,"上传文件出错");

    private int code;
    private String msg;

    FileExceptionEnum(int code, String msg) {
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
