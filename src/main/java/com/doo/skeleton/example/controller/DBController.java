package com.doo.skeleton.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.doo.skeleton.example.dto.RequestDto;
import com.doo.skeleton.example.dto.ResponseDto;
import com.doo.skeleton.example.service.DBService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/example")
@RequiredArgsConstructor
public class DBController {

	private final Logger logger = LoggerFactory.getLogger(DBController.class);
	private final DBService dbService;
	
	@RequestMapping(value = "/maria", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseDto maria(RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.DBController.maria.requestDto : {}", requestDto);
		ResponseDto responseDto = new ResponseDto();

		dbService.maria();
		dbService.mariaMybatis();
		
		return responseDto;
	}
	
	@RequestMapping(value = "/mysql", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseDto mysql(RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.DBController.maria.requestDto : {}", requestDto);
		ResponseDto responseDto = new ResponseDto();

		dbService.mysql();
		
		return responseDto;
	}
	
	@RequestMapping(value = "/db2", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseDto db2(RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.DBController.maria.requestDto : {}", requestDto);
		ResponseDto responseDto = new ResponseDto();

		dbService.db2();
		
		return responseDto;
	}
	
	@RequestMapping(value = "/mongo", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseDto mongo(RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.DBController.mongo.requestDto : {}", requestDto);
		ResponseDto responseDto = new ResponseDto();

		dbService.mongo();
		
		return responseDto;
	}
	
	@RequestMapping(value = "/mongo/insert", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseDto mongoInsert(RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.DBController.mongoInsert.requestDto : {}", requestDto);
		ResponseDto responseDto = new ResponseDto();

		dbService.mongoInsert();
		
		return responseDto;
	}
	
	@RequestMapping(value = "/oracle", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseDto oracle(RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.DBController.oracle.requestDto : {}", requestDto);
		ResponseDto responseDto = new ResponseDto();

		dbService.oracleMybatis();
		
		return responseDto;
	}
}
