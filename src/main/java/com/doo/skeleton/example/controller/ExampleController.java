package com.doo.skeleton.example.controller;

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

	@RequestMapping(value = "/example1", method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> example1(@RequestBody RequestDto requestDto) {
		
		ResponseDto responseDto = new ResponseDto();
		
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(responseDto);
	}
	
}
