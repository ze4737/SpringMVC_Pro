package com.springmvc.entity.vo.log;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZE on 1/8.
 */
public class LoginLog implements Serializable {
    private int loginLogid;
    private int userid;
    private String ip;
    private Date loginDate;

    public int getLoginLogid() {
        return loginLogid;
    }

    public void setLoginLogid(int loginLogid) {
        this.loginLogid = loginLogid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
