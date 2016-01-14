package com.springmvc.controller;

import com.springmvc.entity.vo.form.LoginInput;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ZE on 1/11.
 */
@Controller
@RequestMapping(value = "/login", method = RequestMethod.GET)
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String login(){
        return "/login/login";
    }

    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public ModelAndView loginTest(HttpServletRequest request,HttpServletResponse response,
                                 @PathVariable("user") String user, ModelMap modelMap) throws Exception {
        System.out.println("登录中：" + user);
        modelMap.put("loginUser", user);
        return new ModelAndView("/login/hello", modelMap);
    }

    @RequestMapping(value = "/check")
    public ModelAndView loginCheck(HttpServletRequest request, LoginInput loginInput){
        ModelMap modelMap = new ModelMap();
        ModelAndView modelAndView = null;

        boolean isSuccess = userService.hasMatchUser(loginInput.getUsername(), loginInput.getPassword());
        if(isSuccess){
            modelMap.put("loginUser",loginInput.getUsername());
            modelAndView = new ModelAndView("/login/hello", modelMap);
        }else{
            modelMap.put("errorMsg","用户名密码错误");
            modelAndView = new ModelAndView("/login/login", modelMap);
        }
        return modelAndView;
    }

}
