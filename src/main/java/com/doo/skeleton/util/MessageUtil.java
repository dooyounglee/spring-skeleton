package com.doo.skeleton.util;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

public class MessageUtil {

	private static Locale defulatLocale = Locale.KOREAN;
	
	public static String getMessage(String messageCode) {
		MessageSource messageSource = (MessageSource) BeanUtil.getBean("messageSource");
		
		try {
			return messageSource.getMessage(messageCode, null, defulatLocale);
		} catch (NoSuchMessageException e) {
			return messageCode;
		}
	}
	
	public static String getMessage(String messageCode, Object[] args) {
		MessageSource messageSource = (MessageSource) BeanUtil.getBean("messageSource");
		
		try {
			return messageSource.getMessage(messageCode, args, defulatLocale);
		} catch (NoSuchMessageException e) {
			return messageCode;
		}
	}
	
	public static String getMessage(String messageCode, Object[] args, Locale locale) {
		if (locale == null) locale = defulatLocale;
		MessageSource messageSource = (MessageSource) BeanUtil.getBean("messageSource");
		
		try {
			return messageSource.getMessage(messageCode, args, locale);
		} catch (NoSuchMessageException e) {
			return messageCode;
		}
	}
	
	public static String getMessageDB(String messageCode) {
		MessageSource messageSource = (MessageSource) BeanUtil.getBean("messageSourceDB");
		return messageSource.getMessage(messageCode, null, defulatLocale);
	}
	
	public static String getMessageDB(String messageCode, Object[] args) {
		MessageSource messageSource = (MessageSource) BeanUtil.getBean("messageSourceDB");
		return messageSource.getMessage(messageCode, args, defulatLocale);
	}
	
	public static String getMessageDB(String messageCode, Object[] args, Locale locale) {
		if (locale == null) locale = defulatLocale;
		MessageSource messageSource = (MessageSource) BeanUtil.getBean("messageSourceDB");
		return messageSource.getMessage(messageCode, args, locale);
	}
}
