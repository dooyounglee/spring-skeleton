package com.doo.skeleton.repository.second;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import com.doo.skeleton.db.config.SecondDataConfig;
import com.doo.skeleton.repository.second.example.MysqlRepository;
import com.doo.skeleton.repository.second.example.vo.MysqlDto;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ImportAutoConfiguration(classes = SecondDataConfig.class)
public class MysqlRepositoryTest {

	@Autowired
	private MysqlRepository mysqlRepository;
	
	@Test
	@Transactional("secondTransactionManager")
	public void saveTest() {
		MysqlDto result = mysqlRepository.save(new MysqlDto());
		assertEquals(result.getId(), 1);
	}
}
