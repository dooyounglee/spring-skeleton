package com.doo.skeleton.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.doo.skeleton.example.dto.FirstDto;
import com.doo.skeleton.example.dto.SecondDto;
import com.doo.skeleton.example.service.DBService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/example")
@RequiredArgsConstructor
public class DBController {

	private final Logger logger = LoggerFactory.getLogger(DBController.class);
	private final DBService dbService;
	
	@RequestMapping(value = "/first", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Flux<FirstDto> first(FirstDto firstDto) {
		logger.debug("com.doo.skeleton.example.controller.DBController.first.firstDto : {}", firstDto);
		
		return dbService.first();
	}
	
	@RequestMapping(value = "/second", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Flux<SecondDto> second(SecondDto secondDto) {
		logger.debug("com.doo.skeleton.example.controller.DBController.second.secondDto : {}", secondDto);
		
		return dbService.second();
	}
}
