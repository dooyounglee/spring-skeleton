package com.doo.skeleton.util;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import com.doo.skeleton.config.message.CustomMessageSource;

public class MessageUtil {

	private final static MessageSource messageSource = (MessageSource) BeanUtil.getBean("messageSource");
	private final static CustomMessageSource messageSourceDB = (CustomMessageSource) BeanUtil.getBean("messageSourceDB");
	
	private static Locale defulatLocale = Locale.KOREAN;
	
	public static String getMessage(String messageCode) {
		
		try {
			return messageSource.getMessage(messageCode, null, defulatLocale);
		} catch (NoSuchMessageException e) {
			return messageCode;
		}
	}
	
	public static String getMessage(String messageCode, Object[] args) {
		
		try {
			return messageSource.getMessage(messageCode, args, defulatLocale);
		} catch (NoSuchMessageException e) {
			return messageCode;
		}
	}
	
	public static String getMessage(String messageCode, Object[] args, Locale locale) {
		if (locale == null) locale = defulatLocale;
		
		try {
			return messageSource.getMessage(messageCode, args, locale);
		} catch (NoSuchMessageException e) {
			return messageCode;
		}
	}
	
	public static String getMessageDB(String messageCode) {
		return messageSourceDB.getMessage(messageCode, null, defulatLocale);
	}
	
	public static String getMessageDB(String messageCode, Object[] args) {
		return messageSourceDB.getMessage(messageCode, args, defulatLocale);
	}
	
	public static String getMessageDB(String messageCode, Object[] args, Locale locale) {
		if (locale == null) locale = defulatLocale;
		return messageSourceDB.getMessage(messageCode, args, locale);
	}
}
