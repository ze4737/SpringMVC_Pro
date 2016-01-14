package com.springmvc.controller;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/1/14 0014.
 */
public class LoginControllerTest {

    @Test
    public void testLoginTest() throws Exception {
        String configPath = "advice/adviceBeans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        LoginController controller = (LoginController) ctx.getBean("login");

        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ModelMap modelMap = new ModelMap();
        String user = "admin";

        controller.loginTest(request, response, user, modelMap);
    }
}
