package com.dlc.hr_module.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRequest {

    @SerializedName("userser")
    @Expose
    private User user;
    @SerializedName("token")
    @Expose
    private String token ;

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserRequest(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUserser(User user) {
        this.user = user;
    }
}