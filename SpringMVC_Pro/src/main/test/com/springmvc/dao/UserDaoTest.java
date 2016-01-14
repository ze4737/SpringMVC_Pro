package com.springmvc.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/1/14 0014.
 */
public class UserDaoTest {

    @Test
    public void testTestUpdate() throws Exception {
        String configPath = "beans/aopBeans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        UserDao dao = (UserDao) ctx.getBean("userDao");
        dao.testUpdate();
    }
}