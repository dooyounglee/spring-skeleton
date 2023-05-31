package com.doo.skeleton.message.dto;

import java.util.List;

import com.doo.skeleton.repository.first.message.vo.Message;

import lombok.Data;

@Data
public class MessageDto {

	private String id;
	private Message message;
	private List<Message> messageList;
}
