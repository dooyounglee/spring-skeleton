package com.doo.skeleton.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.doo.skeleton.util.MessageUtil;

@RestControllerAdvice
public class BusinessExceptionHandler {

	@ExceptionHandler(value = { BusinessException.class })
	public ResponseEntity<Object> handlerBusinessException(BusinessException e) {
		e.printStackTrace();
		
		e.setErrorCode(-100);
		e.setMessage(MessageUtil.getMessageDB(e.getMessageCode(), null, null));
		
		return ResponseEntity
				.status(HttpStatus.EXPECTATION_FAILED)
				.body(e);
	}
	
	@ExceptionHandler(value = { RuntimeException.class })
	public ResponseEntity<BusinessException> handlerRuntimeException(RuntimeException e) {
		e.printStackTrace();
		
		BusinessException be = new BusinessException("CM-0001");
		be.setErrorCode(-1);
		be.setMessage("서버에 문제가 발생했습니다. 관리자에게 문의 하세요.");
		
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(be);
	}
	
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<BusinessException> handlerException(Exception e) {
		e.printStackTrace();
		
		BusinessException be = new BusinessException("CM-0001");
		be.setErrorCode(-1);
		be.setMessage(MessageUtil.getMessageDB("CM-0001", null, null));
		
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(be);
	}
}
