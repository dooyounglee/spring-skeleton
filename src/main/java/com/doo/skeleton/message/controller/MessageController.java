package com.doo.skeleton.message.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.doo.skeleton.example.dto.RequestDto;
import com.doo.skeleton.message.dto.MessageDto;
import com.doo.skeleton.message.service.MessageService;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public MessageDto select(RequestDto requestDto) {
		logger.debug("com.doo.skeleton.message.controller.MessageController.getList.requestDto : {}", requestDto);
		MessageDto responseDto = new MessageDto();
		
		responseDto.setMessageList(messageService.select());
		
		return responseDto;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public MessageDto insert(@RequestBody MessageDto requestDto) {
		logger.debug("com.doo.skeleton.message.controller.MessageController.insert.requestDto : {}", requestDto);
		MessageDto responseDto = new MessageDto();
		
		responseDto.setMessageList(messageService.insert(requestDto));
		
		return responseDto;
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public MessageDto update(@RequestBody MessageDto requestDto) {
		logger.debug("com.doo.skeleton.message.controller.MessageController.update.requestDto : {}", requestDto);
		MessageDto responseDto = new MessageDto();
		
		responseDto.setMessage(messageService.update(requestDto));
		
		return responseDto;
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public MessageDto delete(@RequestBody MessageDto requestDto) {
		logger.debug("com.doo.skeleton.message.controller.MessageController.delete.requestDto : {}", requestDto);
		MessageDto responseDto = new MessageDto();
		
		messageService.delete(requestDto);
		
		return responseDto;
	}
}
