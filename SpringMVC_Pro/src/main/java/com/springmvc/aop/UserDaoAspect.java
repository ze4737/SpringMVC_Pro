package com.springmvc.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/1/14 0014.
 */
@Aspect
@Component
public class UserDaoAspect {
    @Pointcut("execution(* com.springmvc.dao.UserDao.*(..))")
    public void logPointcutName(){};

    @Before("logPointcutName()")
    public void before(){
        System.out.println("before 写入日志");
    }

    @AfterReturning("logPointcutName()")
    public void afterReturn(){
        System.out.println("after 写入日志");
    }

    @After("logPointcutName()")
    public void after(){
        System.out.println("finally after");
    }

}
