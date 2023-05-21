package com.doo.skeleton.example.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.doo.skeleton.example.dto.RequestDto;
import com.doo.skeleton.example.dto.ResponseDto;
import com.doo.skeleton.example.service.ExampleService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ExampleController.class)
@TestMethodOrder(OrderAnnotation.class)
public class ExampleControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private ExampleService exampleService;
	
	@Test
	@Order(1)
	public void getTest() throws Exception {
		
		// given
		ResponseDto responseDto = new ResponseDto();
		
		// when
		doNothing().when(exampleService).getVoid();
		when(exampleService.get()).thenReturn(responseDto);
		
		// then
		this.mockMvc.perform(get("/api/v1/example/example1")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isAccepted())
		// .andExpect(content().string(containsString("1")));
		.andExpect(jsonPath("$.id", IsNull.nullValue()))
		.andExpect(jsonPath("$.age", is(0)))
		.andExpect(jsonPath("$.id", is(responseDto.getId())))
		.andExpect(jsonPath("$.age", is(responseDto.getAge())));
	}
	
	@Test
	@Order(2)
	public void postTest() throws Exception {
		
		// given
		ResponseDto responseDto = new ResponseDto();
		
		// when
		doNothing().when(exampleService).postVoid();
		when(exampleService.post()).thenReturn(responseDto);
		
		// then
		this.mockMvc.perform(post("/api/v1/example/example1")
				.content(objectMapper.writeValueAsString(new RequestDto()))
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isAccepted())
		// .andExpect(content().string(containsString("1")));
		.andExpect(jsonPath("$.id", IsNull.nullValue()))
		.andExpect(jsonPath("$.age", is(0)))
		.andExpect(jsonPath("$.id", is(responseDto.getId())))
		.andExpect(jsonPath("$.age", is(responseDto.getAge())));
	}
	
	@Test
	@Order(3)
	public void putTest() throws Exception {
		
		// given
		ResponseDto responseDto = new ResponseDto();
		
		// when
		doNothing().when(exampleService).putVoid();
		when(exampleService.put()).thenReturn(responseDto);
		
		// then
		this.mockMvc.perform(put("/api/v1/example/example1")
				.content(objectMapper.writeValueAsString(new RequestDto()))
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isAccepted())
		// .andExpect(content().string(containsString("1")));
		.andExpect(jsonPath("$.id", IsNull.nullValue()))
		.andExpect(jsonPath("$.age", is(0)))
		.andExpect(jsonPath("$.id", is(responseDto.getId())))
		.andExpect(jsonPath("$.age", is(responseDto.getAge())));
	}
	
	@Test
	@Order(4)
	public void deleteTest() throws Exception {
		
		// given
		ResponseDto responseDto = new ResponseDto();
		
		// when
		doNothing().when(exampleService).deleteVoid();
		when(exampleService.delete()).thenReturn(responseDto);
		
		// then
		this.mockMvc.perform(delete("/api/v1/example/example1")
				.content(objectMapper.writeValueAsString(new RequestDto()))
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isAccepted())
		// .andExpect(content().string(containsString("1")));
		.andExpect(jsonPath("$.id", IsNull.nullValue()))
		.andExpect(jsonPath("$.age", is(0)))
		.andExpect(jsonPath("$.id", is(responseDto.getId())))
		.andExpect(jsonPath("$.age", is(responseDto.getAge())));
	}
}
