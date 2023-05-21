package com.doo.skeleton.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.doo.skeleton.example.dto.db.first.MariaDto;

public class ExampleTest {

	@Test
	void test() {
		MariaDto mariaDto = new MariaDto();
		
		assertEquals(0, mariaDto.getId());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3, Integer.MAX_VALUE})
	void parameterizedTest(int x) {
		MariaDto mariaDto = new MariaDto();
		
		assertEquals(x, x == 0 ? mariaDto.getId() : x);
	}
}
