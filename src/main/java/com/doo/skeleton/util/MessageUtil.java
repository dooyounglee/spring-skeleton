package com.doo.skeleton.util;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageUtil {

	public static String getMessage(String messageCode, Object[] args, Locale locale) {
		MessageSource messageSource = (MessageSource) BeanUtil.getBean("messageSource");
		return messageSource.getMessage(messageCode, args, locale);
	}
	
	public static String getMessageDB(String messageCode, Object[] args, Locale locale) {
		MessageSource messageSource = (MessageSource) BeanUtil.getBean("messageSourceDB");
		return messageSource.getMessage(messageCode, args, locale);
	}
}
