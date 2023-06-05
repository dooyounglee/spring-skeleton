package com.doo.skeleton.message.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.doo.skeleton.message.dto.MessageDto;
import com.doo.skeleton.repository.first.message.MessageRepository;
import com.doo.skeleton.repository.first.message.vo.Message;

@SpringBootTest
@AutoConfigureMockMvc
public class MessageServiceTest {

	@Autowired
	private MessageService messageService;
	
	@MockBean
	private MessageRepository messageRepository;
	
	@Test
	public void selectTest() {
		
		// given
		List<Message> messageList = new ArrayList<>();
		messageList.add(Message.builder()
				.messageCd("XX-0001")
				.messageCn("XX-테스트0001")
				.build());
		
		// when
		when(messageRepository.findAll()).thenReturn(messageList);
		
		// then
		List<Message> result = messageService.select();
		assertEquals(result.size(), 1);
		assertEquals(result.get(0).getMessageCd(), "XX-0001");
		assertEquals(result.get(0).getMessageCn(), "XX-테스트0001");
	}
	
	@Test
	public void insertTest() {
		
		// given
		List<Message> messageList = new ArrayList<>();
		messageList.add(Message.builder()
				.messageCd("XX-0001")
				.messageCn("XX-테스트0001")
				.build());
		MessageDto requestDto = new MessageDto();
		requestDto.setMessageList(messageList);
		
		// when
		when(messageRepository.saveAll(messageList)).thenReturn(messageList);
		
		// then
		List<Message> result = messageService.insert(requestDto);
		assertEquals(result.size(), 1);
		assertEquals(result.get(0).getMessageCd(), "XX-0001");
		assertEquals(result.get(0).getMessageCn(), "XX-테스트0001");
	}
	
	@Test
	public void updateTest() {
		
		// given
		Message message = Message.builder()
				.messageCd("XX-0001")
				.messageCn("XX-테스트0001")
				.build();
		MessageDto requestDto = new MessageDto();
		requestDto.setMessage(message);
		
		// when
		when(messageRepository.save(message)).thenReturn(message);
		
		// then
		Message result = messageService.update(requestDto);
		assertEquals(result.getMessageCd(), "XX-0001");
		assertEquals(result.getMessageCn(), "XX-테스트0001");
	}
}
