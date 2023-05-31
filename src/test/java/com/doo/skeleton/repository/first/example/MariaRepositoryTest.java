package com.doo.skeleton.repository.first.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import com.doo.skeleton.db.config.FirstDataConfig;
import com.doo.skeleton.repository.first.example.MariaRepository;
import com.doo.skeleton.repository.first.example.vo.MariaDto;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ImportAutoConfiguration(classes = FirstDataConfig.class)
public class MariaRepositoryTest {

	@Autowired
	private MariaRepository mariaRepository;
	
	@Test
	@Transactional("firstTransactionManager")
	public void saveTest() {
		MariaDto result = mariaRepository.save(new MariaDto());
		assertEquals(result.getId(), 1);
	}
}
