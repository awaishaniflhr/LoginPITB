package com.example.loginpitb;

import java.util.Date;

public class Data {
    public int user_Id;
    public String name;
    public String user_name;
    public String password;
    public String token;
    public Date expiry;

    public int getUser_Id() {
        return user_Id;
    }

    public String getName() {
        return name;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }
}
