package com.sanwenyu.network.response;

/**
 * 返回结果封装
 */

public class Response<T> {

    private int code; // 返回的code
    private T data; // 具体的数据结果
    private String msg; // message 可用来返回接口的说明

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public boolean success() {
        return "1".equals(code);
    }

    @Override
    public String toString() {
        return "BaseRespose{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
