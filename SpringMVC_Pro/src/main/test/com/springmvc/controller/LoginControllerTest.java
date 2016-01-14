package com.springmvc.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/1/14 0014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans/adviceBeans.xml"})
@Transactional
public class LoginControllerTest {
    @Qualifier("login")
    @Autowired
    LoginController controller;

    @Test
    public void testLoginTest() throws Exception {
//        String configPath = "beans/adviceBeans.xml";
//        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
//        LoginController controller = (LoginController) ctx.getBean("login");

        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ModelMap modelMap = new ModelMap();
        String user = "admin";

        controller.loginTest(request, response, user, modelMap);
    }
}
