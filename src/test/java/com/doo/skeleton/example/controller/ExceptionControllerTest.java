package com.doo.skeleton.example.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ExceptionController.class)
public class ExceptionControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void businessexception() throws Exception {
		
		// then
		this.mockMvc.perform(get("/api/v1/example/exception/businessexception")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isExpectationFailed())
		// .andExpect(jsonPath("$.messageCd", is("Test")))
		// .andExpect(jsonPath("$.httpStatus", is(HttpStatus.EXPECTATION_FAILED)))
		;
	}
	
	@Test
	public void nullpoint() throws Exception {
		
		// then
		this.mockMvc.perform(get("/api/v1/example/exception/nullpoint")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isInternalServerError())
		// .andExpect(jsonPath("$.status", is(500)))
		// .andExpect(jsonPath("$.error", is("Internal Server Error")))
		// .andExpect(jsonPath("$.httpStatus", is(HttpStatus.EXPECTATION_FAILED)))
		;
	}
}
