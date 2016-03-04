package com.springmvc.dao;

import com.springmvc.entity.dto.User;

import java.util.Map;

/**
 * Created by dev on 16-3-4.
 */
public interface IUserDao {
    public int getMatchCount(String username, String password);
    public Map<String, Object> findUserByUserName(final String username);
    public void updateLoginInfo(User user);
    public long queryUserCount();
    public Map<String, Object> queryUserById();
}
