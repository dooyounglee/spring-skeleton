package com.doo.skeleton.message.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.doo.skeleton.message.dto.MessageDto;
import com.doo.skeleton.repository.first.message.MessageRepository;
import com.doo.skeleton.repository.first.message.vo.Message;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageService {

	private final MessageRepository messageRepository;
	
	public List<Message> select() {
		return messageRepository.findAll();
	}
	
	public List<Message> insert(MessageDto messageDto) {
		return messageRepository.saveAll(messageDto.getMessageList());
	}
	
	public Message update(MessageDto messageDto) {
		return messageRepository.save(messageDto.getMessage());
	}
	
	public void delete(MessageDto messageDto) {
		messageRepository.deleteById(messageDto.getId());
	}

}
