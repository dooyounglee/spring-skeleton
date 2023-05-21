package com.doo.skeleton.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doo.skeleton.example.dto.RequestDto;
import com.doo.skeleton.example.dto.ResponseDto;
import com.doo.skeleton.example.service.ExampleService;

@RestController
@RequestMapping("/api/v1/example")
public class ExampleController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ExampleService exampleService;

	@RequestMapping(value = "/example1", method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> getExample1(RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.ExampleController.getExample1.requestDto : {}", requestDto);
		
		exampleService.getVoid();
		exampleService.get();
		
		ResponseDto responseDto = new ResponseDto();
		
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(responseDto);
	}
	
	@RequestMapping(value = "/example1", method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> postExample1(@RequestBody RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.ExampleController.postExample1.requestDto : {}", requestDto);
		
		exampleService.postVoid();
		exampleService.post();
		
		ResponseDto responseDto = new ResponseDto();
		
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(responseDto);
	}
	
	@RequestMapping(value = "/example1", method = RequestMethod.PUT)
	public ResponseEntity<ResponseDto> putExample1(@RequestBody RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.ExampleController.putExample1.requestDto : {}", requestDto);
		
		exampleService.putVoid();
		exampleService.put();
		
		ResponseDto responseDto = new ResponseDto();
		
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(responseDto);
	}
	
	@RequestMapping(value = "/example1", method = RequestMethod.DELETE)
	public ResponseEntity<ResponseDto> deleteExample1(@RequestBody RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.ExampleController.deleteExample1.requestDto : {}", requestDto);
		
		exampleService.deleteVoid();
		exampleService.delete();
		
		ResponseDto responseDto = new ResponseDto();
		
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(responseDto);
	}
}
