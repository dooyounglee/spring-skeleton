package com.doo.skeleton.repository.fourth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;

import com.doo.skeleton.repository.fourth.example.MongoRepository;
import com.doo.skeleton.repository.fourth.example.vo.MongoDto;

@SpringBootTest
@AutoConfigureDataMongo
@TestInstance(Lifecycle.PER_CLASS)
public class MongoRepositoryTest {

	@Autowired
	private MongoRepository mongoRepository;
	
	@AfterAll
	public void afterAll() {
		mongoRepository.deleteById("test1");
	}
	
	@Test
	public void saveTest() {
		MongoDto result = mongoRepository.save(new MongoDto("test1"));
		assertEquals(result.getId(), "test1");
	}
}
