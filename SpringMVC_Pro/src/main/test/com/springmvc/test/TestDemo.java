package com.springmvc.test;

import com.springmvc.dao.IUserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by dev on 16-3-4.
 */
@Component
public class TestDemo {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public void doTest(){
        System.out.println("====TestDemo doTest====");

        SqlSession ss = sqlSessionFactory.openSession();
        IUserDao userMapper = ss.getMapper(IUserDao.class);
        long rs = userMapper.queryUserCount();
        System.out.println("===" + rs);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println("====ApplicationContext Create Success====");
        TestDemo demo = (TestDemo) ctx.getBean("testDemo");
        demo.doTest();

    }
}
