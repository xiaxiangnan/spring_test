package com.journey.spring.quick.start.web;

/**
 * POJO
 * Created by zhangyuan on 15/12/20.
 */
public class LoginCommand {

    private String userName;

    private String password;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
