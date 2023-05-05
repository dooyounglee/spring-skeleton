package com.doo.skeleton.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doo.skeleton.example.dto.RequestDto;
import com.doo.skeleton.example.dto.ResponseDto;

@RestController
@RequestMapping("/api/v1/example")
public class ExampleController {
	
	private final Logger logger = LoggerFactory.getLogger(ExampleController.class);

	@RequestMapping(value = "/example1", method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> example1(RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.ExampleController.example1.requestDto : {}", requestDto);
		
		ResponseDto responseDto = new ResponseDto();
		
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(responseDto);
	}
	
	@RequestMapping(value = "/example2", method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> example2(@RequestBody RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.ExampleController.example2.requestDto : {}", requestDto);
		
		ResponseDto responseDto = new ResponseDto();
		
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(responseDto);
	}
	
	@RequestMapping(value = "/example3", method = RequestMethod.PUT)
	public ResponseEntity<ResponseDto> example3(@RequestBody RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.ExampleController.example3.requestDto : {}", requestDto);
		
		ResponseDto responseDto = new ResponseDto();
		
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(responseDto);
	}
}
