package com.doo.skeleton.db.mybatis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.doo.skeleton.repository.first.example.vo.MariaDto;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class MariaMapperTest {

	String namespace = "com.doo.skeleton.db.mybatis.MariaMapperTest.";

	@Autowired
	private MariaMapper mapper;
	
	@BeforeAll
	public void beforeAll() {
		mapper.insert(namespace + "insertTest", new MariaDto(9991));
		mapper.insert(namespace + "insertTest", new MariaDto(9992));
	}
	
	@AfterAll
	public void afterAll() {
		mapper.delete(namespace + "deleteTest", new MariaDto(9991));
		mapper.delete(namespace + "deleteTest", new MariaDto(9992));
	}
	
	@Test
	@Transactional
	public void selectTest() {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("prefix", 9990);
		
		List result = mapper.selectList(namespace + "selectTest", param);
		
		assertEquals(result.size(), 2);
	}
}
