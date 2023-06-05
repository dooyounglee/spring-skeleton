package com.doo.skeleton.config.message;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import com.doo.skeleton.repository.first.message.MessageRepository;
import com.doo.skeleton.repository.first.message.vo.Message;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("messageSourceDB")
public class CustomMessageSource extends AbstractMessageSource {

	private Map<String, MessageFormat> messageMap = new HashMap<>();
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	protected MessageFormat resolveCode(String code, Locale locale) {
		MessageFormat messageFormat = this.messageMap.get(code);
		if (messageFormat == null) {
			Optional<Message> oMsgMap = messageRepository.findById(code);
			if (oMsgMap.isPresent()) {
				Message message = oMsgMap.get();
				return createMessageFormat(message.getMessageCn(), locale);
			} else {
				return null;
			}
		} else {
			return messageMap.get(code);
		}
	}

	@PostConstruct
	private void loadMessage() {
		List<Message> messageList = messageRepository.findAll();
		log.debug("messageList: {}", messageList);
		messageList.stream().forEach(message ->
			this.messageMap.put(message.getMessageCd(), createMessageFormat(message.getMessageCn(), Locale.KOREAN)));
		
	}
}
