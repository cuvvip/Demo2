package com.example.demo2.Activity.RecycleDemo.pojo;

public class Person {

    private String username;
    private String userinformation;
    private int good;

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", userinformation='" + userinformation + '\'' +
                ", good=" + good +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserinformation() {
        return userinformation;
    }

    public void setUserinformation(String userinformation) {
        this.userinformation = userinformation;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }
}
