package com.example.demo2.Activity.WebDemo;

import java.io.Serializable;
import java.util.Date;

public class Shopping implements Serializable {
    private String shoppingId;

    private String shoppingName;

    private String shoppingInformation;

    private Double shoppingPrice;

    private Integer shoppingNumber;

    private Integer shoppingTotal;

    private String shoppingImgurl;

    private Date shoppingDate;

    private Integer shoppingGood;

    public String getShoppingId() {
        return shoppingId;
    }

    public void setShoppingId(String shoppingId) {
        this.shoppingId = shoppingId == null ? null : shoppingId.trim();
    }

    public String getShoppingName() {
        return shoppingName;
    }

    public void setShoppingName(String shoppingName) {
        this.shoppingName = shoppingName == null ? null : shoppingName.trim();
    }

    public String getShoppingInformation() {
        return shoppingInformation;
    }

    public void setShoppingInformation(String shoppingInformation) {
        this.shoppingInformation = shoppingInformation == null ? null : shoppingInformation.trim();
    }

    public Double getShoppingPrice() {
        return shoppingPrice;
    }

    public void setShoppingPrice(Double shoppingPrice) {
        this.shoppingPrice = shoppingPrice;
    }

    public Integer getShoppingNumber() {
        return shoppingNumber;
    }

    public void setShoppingNumber(Integer shoppingNumber) {
        this.shoppingNumber = shoppingNumber;
    }

    public Integer getShoppingTotal() {
        return shoppingTotal;
    }

    public void setShoppingTotal(Integer shoppingTotal) {
        this.shoppingTotal = shoppingTotal;
    }

    public String getShoppingImgurl() {
        return shoppingImgurl;
    }

    public void setShoppingImgurl(String shoppingImgurl) {
        this.shoppingImgurl = shoppingImgurl == null ? null : shoppingImgurl.trim();
    }

    public Date getShoppingDate() {
        return shoppingDate;
    }

    public void setShoppingDate(Date shoppingDate) {
        this.shoppingDate = shoppingDate;
    }

    public Integer getShoppingGood() {
        return shoppingGood;
    }

    public void setShoppingGood(Integer shoppingGood) {
        this.shoppingGood = shoppingGood;
    }
}