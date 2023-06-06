package com.doo.skeleton.config.exception;

import java.util.Locale;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 7645993055596767016L;
	
	private String messageCode;
	private Object[] messageArgs;
	private Locale locale;
	private int errorCode;
	private String message;
	
	public BusinessException(String messageCode) {
		super(messageCode);
		this.messageCode = messageCode;
	}
	
	public BusinessException(String messageCode, Object[] args) {
		super(messageCode);
		this.messageCode = messageCode;
		this.messageArgs = args;
	}
	
	public BusinessException(String messageCode, Object[] args, Locale locale) {
		super(messageCode);
		this.messageCode = messageCode;
		this.messageArgs = args;
		this.locale = locale;
	}
	
	public BusinessException(String messageCode, Object[] args, Locale locale, Throwable e) {
		super(e);
		this.messageCode = messageCode;
		this.messageArgs = args;
		this.locale = locale;
	}

}
