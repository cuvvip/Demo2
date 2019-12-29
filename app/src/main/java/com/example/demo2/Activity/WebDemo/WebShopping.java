package com.example.demo2.Activity.WebDemo;

import com.example.demo2.Web.net.revert.BaseResponseEntity;

import java.util.List;

public class WebShopping  {
    private List<Shopping> result;

    private String message;
    private int code;

    @Override
    public String toString() {
        return "WebShopping{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }

    public List<Shopping> getResult() {
        return result;
    }

    public void setResult(List<Shopping> result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
