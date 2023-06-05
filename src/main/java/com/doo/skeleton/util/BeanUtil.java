package com.doo.skeleton.util;

import org.springframework.context.ApplicationContext;

import com.doo.skeleton.config.bean.ApplicationContextProvider;

public class BeanUtil {

	public static Object getBean(String beanId) {
		ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
		return applicationContext.getBean(beanId);
	}
}
