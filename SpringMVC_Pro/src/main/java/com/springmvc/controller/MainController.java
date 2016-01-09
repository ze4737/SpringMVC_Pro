package com.springmvc.controller;

import com.springmvc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ZE on 12/31.
 */
@Controller
public class MainController {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.test();
    }
    @Autowired
    private UserDao userDao;

    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-servlet.xml");
        System.out.println(userDao==null);
        userDao = (UserDao) ac.getBean("userDao");
        int match = userDao.getMatchCount("admin","123456");
        System.out.println(match);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "/welcome";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String registPost() {
        return "/welcome";
    }

    @RequestMapping(value = "/login/{user}", method = RequestMethod.GET)
    public ModelAndView myMethod(HttpServletRequest request,HttpServletResponse response,
                                 @PathVariable("user") String user, ModelMap modelMap) throws Exception {
        modelMap.put("loginUser", user);
        return new ModelAndView("/login/hello", modelMap);
    }

    @RequestMapping(value = "/pages/demopage", method = RequestMethod.GET)
    public String demoPage1(){
        return "/pages/demopage/demoPage1";
    }
}
