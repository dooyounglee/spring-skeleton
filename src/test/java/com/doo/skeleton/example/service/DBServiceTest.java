package com.doo.skeleton.example.service;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.doo.skeleton.db.mybatis.Db2Mapper;
import com.doo.skeleton.db.mybatis.MariaMapper;
import com.doo.skeleton.db.mybatis.OracleMapper;
import com.doo.skeleton.example.dto.db.fourth.MongoDto;
import com.doo.skeleton.example.repository.first.MariaRepository;
import com.doo.skeleton.example.repository.fourth.MongoRepository;
import com.doo.skeleton.example.repository.second.MysqlRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class DBServiceTest {

	@Autowired
	private DBService dbService;
	
	@MockBean private MariaRepository mariaRepository;
	@MockBean private MariaMapper mariaMapper;
	@MockBean private MysqlRepository mysqlRepository;
	@MockBean private Db2Mapper db2Mapper;
	@MockBean private MongoRepository mongoRepository;
	@MockBean private OracleMapper oracleMapper;
	
	@Test
	public void mariaTest() {
		
		dbService.maria();
	}
	
	@Test
	public void mariaMybatisTest() {
		
		dbService.mariaMybatis();
	}
	
	@Test
	public void mysqlTest() {
		
		dbService.mysql();
	}
	
	@Test
	public void db2Test() {
		
		dbService.db2();
	}
	
	@Test
	public void mongoTest() {
		
		dbService.mongo();
	}
	
	@Test
	public void mongoInsert() {
		
		// given
		MongoDto mongoDto = new MongoDto();
		
		// when
		when(mongoRepository.save(mongoDto)).thenReturn(mongoDto);
		
		// then
		dbService.mongoInsert();
	}
	
	@Test
	public void oracleMybatisTest() {
		
		dbService.oracleMybatis();
	}
}
