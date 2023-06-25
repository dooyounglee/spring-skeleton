package com.doo.skeleton.common.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.doo.skeleton.common.user.dto.RequestDto;
import com.doo.skeleton.common.user.dto.ResponseDto;
import com.doo.skeleton.common.user.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseDto register(RequestDto requestDto) {
		log.debug("requestDto : {}", requestDto);
		ResponseDto responseDto = new ResponseDto();
		
		responseDto.setUser(userService.register(requestDto));
		
		return responseDto;
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseDto changePassword(RequestDto requestDto) {
		log.debug("requestDto : {}", requestDto);
		ResponseDto responseDto = new ResponseDto();
		
		responseDto.setUser(userService.changePassword(requestDto));
		
		return responseDto;
	}
}
