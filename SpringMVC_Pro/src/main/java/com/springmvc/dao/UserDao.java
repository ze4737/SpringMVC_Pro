package com.springmvc.dao;

import com.springmvc.entity.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ZE on 1/8.
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String username, String password){
        String sqlStr = "select count(*) from t_user where user_name = ? and password = ?";
        return jdbcTemplate.queryForInt(sqlStr, new Object[]{username, password});
    }

    public User findUserByUserName(final String username){
        String sqlStr = "select user_id,user_name from t_user where user_name = ?";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{username},
                new RowCallbackHandler() {
                    public void processRow(ResultSet resultSet) throws SQLException {
                        user.setUserid(resultSet.getInt("user_id"));
                        user.setUsername(username);
                    }
                }
        );
        return user;
    }

    public void updateLoginInfo(User user){
        String sqlStr = "update t_user set last_visit = ?,last_ip = ? where user_id = ?";
        jdbcTemplate.update(sqlStr, user.getLastvisit(),user.getLastip(),user.getUserid());
    }

}
