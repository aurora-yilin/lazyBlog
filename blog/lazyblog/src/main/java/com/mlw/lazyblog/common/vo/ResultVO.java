package com.mlw.lazyblog.common.vo;

import com.mlw.lazyblog.common.enums.ResultCodeEnum;

import java.io.Serializable;

/**
 * @author oRuol
 * @Date 2020/6/23 19:14
 */
public class ResultVO<T> implements Serializable {

    /**
     * 状态码
     */
    private int code;

    /**
     * 响应信息，用来说明响应情况
     */
    private String msg;

    /**
     * 响应的具体信息
     */
    private T data;

    public ResultVO(T data){
        this(ResultCodeEnum.SUCCESS,data);
    }

    public ResultVO(ResultCodeEnum resultCode, T data){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public ResultVO(ResultCodeEnum resultCode){
        this(resultCode,null);
    }

    public ResultVO(int code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVO(int code,String msg){
        this(code,msg,null);
    }

    public ResultVO() {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
