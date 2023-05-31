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

import com.doo.skeleton.repository.third.example.vo.Db2Dto;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class Db2MapperTest {
	
	String mapper = "com.doo.skeleton.db.mybatis.Db2MapperTest.";

	@Autowired
	private Db2Mapper db2Mapper;
	
	@BeforeAll
	public void beforeAll() {
		db2Mapper.insert(mapper + "insertTest", new Db2Dto("test1"));
		db2Mapper.insert(mapper + "insertTest", new Db2Dto("test2"));
	}
	
	@AfterAll
	public void afterAll() {
		db2Mapper.delete(mapper + "deleteTest", new Db2Dto("test1"));
		db2Mapper.delete(mapper + "deleteTest", new Db2Dto("test2"));
	}
	
	@Test
	@Transactional
	public void selectTest() {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("prefix", "test");
		
		List result = db2Mapper.selectList(mapper + "selectTest", param);
		
		assertEquals(result.size(), 2);
	}
}
