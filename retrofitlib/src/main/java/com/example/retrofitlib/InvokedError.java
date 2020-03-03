package com.example.retrofitlib;


//此类可以处理一些公共错误码信息
public class InvokedError {
    private int type;
    private String message;
    public static final int TYPE_ERROR_GSON=1;
    public static final int TYPE_ERROR_NET=2;

    public InvokedError(){}

    public InvokedError(int type){
        this.type=type;
        if (type==TYPE_ERROR_NET){
            this.message="数据查询异常";
        }else if(type==TYPE_ERROR_GSON){
            this.message="数据解析异常";
        }
    }



    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
