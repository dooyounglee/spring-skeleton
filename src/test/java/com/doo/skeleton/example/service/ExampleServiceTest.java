package com.doo.skeleton.example.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.doo.skeleton.example.dto.ResponseDto;

@WebMvcTest(ExampleService.class)
@TestMethodOrder(OrderAnnotation.class)
public class ExampleServiceTest {

	@Autowired
	private ExampleService exampleService;
	
	@Test
	@Order(1)
	public void getVoidTest() {
		exampleService.getVoid();
	}
	
	@Test
	@Order(2)
	public void getTest() {
		
		ResponseDto result = exampleService.get();
		assertThat(result.getId()).isNull();
		assertThat(result.getAge()).isEqualTo(0);
	}
}
