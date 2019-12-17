package com.example.demo2.Activity.WebDemo;


import com.example.demo2.Web.net.revert.BaseResponseEntity;
import com.example.demo2.Web.utils.ApiConfig;

public class ShoppingEntity<T> extends BaseResponseEntity {


    private int code;

    @Override
    public boolean success() {
        return ApiConfig.getSucceedCode() == code;
    }

    @Override
    public boolean tokenInvalid() {
        return ApiConfig.getInvalidateToken() == code;
    }

    public T response;

    @Override
    public String toString() {
        return "ShoppingEntity{" +
                "code=" + code +
                ", response=" + response +
                '}';
    }
}
