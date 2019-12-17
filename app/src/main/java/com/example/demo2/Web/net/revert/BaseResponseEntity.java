package com.example.demo2.Web.net.revert;

import com.example.demo2.Web.utils.ApiConfig;

import java.io.Serializable;

public class BaseResponseEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  public int code;

  public String msg;

  public static long getSerialVersionUID() {
    return serialVersionUID;
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

  public boolean success() {
    return ApiConfig.getSucceedCode() == code;
  }

  public boolean tokenInvalid() {
    return ApiConfig.getInvalidateToken() == code;
  }

}
