package com.springmvc;

import com.springmvc.service.BaseService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjectFactory implements ApplicationContextAware {
	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		ObjectFactory.context = context;
	}
	
	public static BaseService getService(String serviceName) {
		return (BaseService)context.getBean(serviceName);
	}
	
	public static Object getObject(String serviceName) {
		return context.getBean(serviceName);
	}
	
	public static void init() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
}
