package com.doo.skeleton.message.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.doo.skeleton.message.dto.MessageDto;
import com.doo.skeleton.message.service.MessageService;
import com.doo.skeleton.repository.first.message.vo.Message;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(MessageController.class)
public class MessageControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private MessageService messageService;
	
	@Test
	public void selectTest() throws Exception {
		
		// given
		List<Message> messageList = new ArrayList<>();
		messageList.add(Message.builder()
				.messageCd("XX-0001")
				.messageCn("XX-테스트0001")
				.build());
		
		// when
		when(messageService.select()).thenReturn(messageList);
		
		// then
		this.mockMvc.perform(get("/api/v1/message")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.messageList.length()", is(1)))
		.andExpect(jsonPath("$.messageList[0].messageCd", is("XX-0001")))
		.andExpect(jsonPath("$.messageList[0].messageCn", is("XX-테스트0001")));
	}
	
	@Test
	public void insertTest() throws Exception {
		
		// given
		List<Message> messageList = new ArrayList<>();
		messageList.add(Message.builder()
				.messageCd("XX-0001")
				.messageCn("XX-테스트0001")
				.build());
		MessageDto requestDto = new MessageDto();
		requestDto.setMessageList(messageList);
		
		// when
		when(messageService.insert(requestDto)).thenReturn(messageList);
		
		// then
		this.mockMvc.perform(post("/api/v1/message")
				.content(objectMapper.writeValueAsString(requestDto))
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.messageList.length()", is(1)))
		.andExpect(jsonPath("$.messageList[0].messageCd", is("XX-0001")))
		.andExpect(jsonPath("$.messageList[0].messageCn", is("XX-테스트0001")));
	}
	
	@Test
	public void updateTest() throws Exception {
		
		// given
		Message message = Message.builder()
				.messageCd("XX-0001")
				.messageCn("XX-테스트0001")
				.build();
		MessageDto requestDto = new MessageDto();
		requestDto.setMessage(message);
		
		// when
		when(messageService.update(requestDto)).thenReturn(message);
		
		// then
		this.mockMvc.perform(put("/api/v1/message")
				.content(objectMapper.writeValueAsString(requestDto))
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.message.messageCd", is("XX-0001")))
		.andExpect(jsonPath("$.message.messageCn", is("XX-테스트0001")));
	}
	
	@Test
	public void deleteTest() throws Exception {
		
		// given
		MessageDto requestDto = new MessageDto();
		requestDto.setId("XX-0001");
		
		// when
		doNothing().when(messageService).delete(requestDto);
		
		// then
		this.mockMvc.perform(delete("/api/v1/message")
				.content(objectMapper.writeValueAsString(requestDto))
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isNoContent());
	}
}
