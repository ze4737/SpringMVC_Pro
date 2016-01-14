package com.springmvc.advice.before;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/1/14 0014.
 */
public class LoginBeforeAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("验证用户名格式是否正确：" + objects[2]);
    }
}
