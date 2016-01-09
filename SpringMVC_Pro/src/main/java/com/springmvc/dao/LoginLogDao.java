package com.springmvc.dao;

import com.springmvc.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by ZE on 1/8.
 */
@Repository
public class LoginLogDao implements Serializable {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLoginLog(LoginLog loginLog){
        String sqlStr = "insert into t_login_log (user_id,ip,login_datetime) vlues(?,?,?)";
        jdbcTemplate.update(sqlStr, loginLog.getUserid(),loginLog.getIp(),loginLog.getLoginDate());
    }
}
