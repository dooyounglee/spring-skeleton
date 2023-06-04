package com.doo.skeleton.util;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageUtil {

    @Autowired
    private MessageSource messageSource;
	
	public String getMessage(String messageCode, Object[] args, Locale locale) {
		return messageSource.getMessage(messageCode, args, locale);
	}
}
