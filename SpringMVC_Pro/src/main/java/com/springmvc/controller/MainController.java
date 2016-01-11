package com.springmvc.controller;

import com.springmvc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ZE on 12/31.
 */
@Controller
public class MainController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "/welcome";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String registPost() {
        return "/welcome";
    }

    @RequestMapping(value = "/pages/demopage", method = RequestMethod.GET)
    public String demoPage1(){
        return "/pages/demopage/demoPage1";
    }
}
