package com.springmvc.entity.vo.form;

/**
 * Created by ZE on 1/11.
 * 接收前台提交的登录表单数据
 */
public class LoginInput {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
