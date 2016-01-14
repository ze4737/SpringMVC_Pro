package com.springmvc.service;

import com.springmvc.dao.LoginLogDao;
import com.springmvc.dao.UserDao;
import com.springmvc.entity.vo.log.LoginLog;
import com.springmvc.entity.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ZE on 1/9.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginLogDao loginLogDao;

    @Transactional(readOnly = true)
    public boolean hasMatchUser(String username, String password){
        int matchcount = userDao.getMatchCount(username, password);
        return matchcount>0;
    }

    @Transactional(readOnly = true)
    public User findUserByUserName(String username){
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
//        userService = (UserService) ctx.getBean("userService");
        User user = userDao.findUserByUserName(username);
        return user;
    }

    @Transactional
    public void loginSuccess(User user){
        LoginLog loginLog = new LoginLog();
        loginLog.setUserid(user.getUserid());
        loginLog.setIp(user.getLastip());
        loginLog.setLoginDate(user.getLastvisit());
        loginLogDao.insertLoginLog(loginLog);
    }

}
