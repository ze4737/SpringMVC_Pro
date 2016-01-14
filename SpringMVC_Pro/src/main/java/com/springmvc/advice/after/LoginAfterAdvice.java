package com.springmvc.advice.after;

import com.google.gson.Gson;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/1/14 0014.
 */
public class LoginAfterAdvice implements AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("登录验证结果：");
        Gson gson = new Gson();
        System.out.println(gson.toJson(o));
        System.out.println(gson.toJson(objects));
        System.out.println(gson.toJson(o1));
    }
}
