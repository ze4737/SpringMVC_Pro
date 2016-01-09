package com.springmvc.service;

import com.springmvc.dao.LoginLogDao;
import com.springmvc.dao.UserDao;
import com.springmvc.domain.LoginLog;
import com.springmvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZE on 1/9.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String username, String password){
        int matchcount = userDao.getMatchCount(username, password);
        return matchcount>0;
    }

    public User findUserByUserName(String username){
        User user = userDao.findUserByUserName(username);
        return user;
    }

    public void loginSuccess(User user){
        LoginLog loginLog = new LoginLog();
        loginLog.setUserid(user.getUserid());
        loginLog.setIp(user.getLastip());
        loginLog.setLoginDate(user.getLastvisit());
        loginLogDao.insertLoginLog(loginLog);
    }

}
