package com.doo.skeleton.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doo.skeleton.config.exception.BusinessException;
import com.doo.skeleton.example.dto.RequestDto;
import com.doo.skeleton.example.dto.ResponseDto;

@RestController
@RequestMapping("/api/v1/example/exception")
public class ExceptionController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/businessexception", method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> businessexception(RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.ExceptionController.businessexception.requestDto : {}", requestDto);
		
		throw new BusinessException("Test");
	}
	
	@RequestMapping(value = "/nullpoint", method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> nullpoint(RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.ExceptionController.nullpoint.requestDto : {}", requestDto);
		
		Map<String, Object> map = new HashMap<>();
		map.get("dd").toString();
		
		return null;
	}
	
	@RequestMapping(value = "/runtime", method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> runtime(RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.ExceptionController.runtime.requestDto : {}", requestDto);
		
		throw new RuntimeException("TTTTTTTTT");
	}
	
}
