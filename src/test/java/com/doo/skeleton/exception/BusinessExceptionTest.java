package com.doo.skeleton.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.doo.skeleton.config.exception.BusinessException;

@SpringBootTest
public class BusinessExceptionTest {

	@Test
	public void exceptionTest() {
		assertThrows(NullPointerException.class, () -> {
			Map<String, Object> map = new HashMap<>();
			map.get("dd").toString();
		}, "aaaa");
	}
	
	@Test
	public void exception_messageTest() {
		assertThrows(BusinessException.class, () -> {
			throw new BusinessException("greeting", new Object[] {"java"}, null);
		});
	}
	
	@Test
	public void classnameTest() {
		System.out.println(this.getClass().descriptorString());
		System.out.println(this.getClass().getName());
		System.out.println(this.getClass().getPackageName());
		System.out.println(this.getClass().getSimpleName());
		System.out.println(this.getClass().getTypeName());
	}
}
