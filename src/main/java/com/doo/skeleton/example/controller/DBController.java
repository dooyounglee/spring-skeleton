package com.doo.skeleton.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ResponseEntity<ResponseDto> maria(RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.DBController.maria.requestDto : {}", requestDto);

		dbService.maria();
		dbService.mariaMybatis();
		
		ResponseDto responseDto = new ResponseDto();
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(responseDto);
	}
	
	@RequestMapping(value = "/mysql", method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> mysql(RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.DBController.maria.requestDto : {}", requestDto);

		dbService.mysql();
		
		ResponseDto responseDto = new ResponseDto();
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(responseDto);
	}
	
	@RequestMapping(value = "/db2", method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> db2(RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.DBController.maria.requestDto : {}", requestDto);

		dbService.db2();
		
		ResponseDto responseDto = new ResponseDto();
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(responseDto);
	}
	
	@RequestMapping(value = "/mongo", method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> mongo(RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.DBController.mongo.requestDto : {}", requestDto);

		dbService.mongo();
		
		ResponseDto responseDto = new ResponseDto();
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(responseDto);
	}
	
	@RequestMapping(value = "/mongo/insert", method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> mongoInsert(RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.DBController.mongoInsert.requestDto : {}", requestDto);

		dbService.mongoInsert();
		
		ResponseDto responseDto = new ResponseDto();
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(responseDto);
	}
	
	@RequestMapping(value = "/oracle", method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> oracle(RequestDto requestDto) {
		logger.debug("com.doo.skeleton.example.controller.DBController.oracle.requestDto : {}", requestDto);

		dbService.oracleMybatis();
		
		ResponseDto responseDto = new ResponseDto();
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(responseDto);
	}
}
