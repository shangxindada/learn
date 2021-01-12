package com.example.demo.model;


import java.io.Serializable;

public class HttpClientResult implements Serializable {

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应数据
     */
    private String content;

    public HttpClientResult(int code,String content){
        this.code = code;
        this.content = content;
    }

    public HttpClientResult(int code){
        this.code = code;
        this.content = "";
    }

    public String toString(){
        return "code:"+code+"content:"+content;
    }
}
