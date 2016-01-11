package com.springmvc.entity.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZE on 1/8.
 * 用户实体类
 */
public class User implements Serializable {
    private int userid;
    private String username;
    private int password;
    private String lastip;
    private Date lastvisit;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getLastip() {
        return lastip;
    }

    public void setLastip(String lastip) {
        this.lastip = lastip;
    }

    public Date getLastvisit() {
        return lastvisit;
    }

    public void setLastvisit(Date lastvisit) {
        this.lastvisit = lastvisit;
    }
}
