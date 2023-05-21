package com.doo.skeleton.example.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.doo.skeleton.example.dto.ResponseDto;
import com.doo.skeleton.example.service.DBService;

// @SpringBootTest + @AutoConfigureMockMvc
@WebMvcTest(DBController.class)
public class DBControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DBService dbService;
	
	@Test
	public void test1() throws Exception {
		
		// given
		ResponseDto responseDto = new ResponseDto();
		
		// when
		doNothing().when(dbService).maria();
		
		// then
		this.mockMvc.perform(get("/api/v1/example/maria")
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
