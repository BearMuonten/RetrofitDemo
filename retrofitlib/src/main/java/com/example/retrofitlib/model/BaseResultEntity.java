package com.example.retrofitlib.model;

public class BaseResultEntity<T>  {


    /**
     * code : 200
     * error_code : 1003
     * error_msg : 无需升级
     * data : {}
     */

    private int code;
    private int error_code;
    private String error_msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
