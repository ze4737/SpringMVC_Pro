package com.springmvc.advice.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Administrator on 2016/1/14 0014.
 */
public class LoginInteceptorAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments();
        String username = (String)args[2];
        System.out.println("日志记录：用户登录验证：" + username);
        Object obj = methodInvocation.proceed();
        System.out.println("日志记录：登录成功或失败：" + username);

        return obj;
    }
}
