package com.doo.skeleton.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.doo.skeleton.db.mybatis.Db2Mapper;
// import com.doo.skeleton.db.mybatis.MariaMapper;
import com.doo.skeleton.example.dto.db.fourth.MongoDto;
import com.doo.skeleton.example.repository.first.MariaRepository;
import com.doo.skeleton.example.repository.fourth.MongoRepository;
import com.doo.skeleton.example.repository.second.MysqlRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DBService {
	
	private final Logger logger = LoggerFactory.getLogger(DBService.class);

	private final MariaRepository mariaRepository;
	private final MysqlRepository mysqlRepository;
	private final Db2Mapper db2Mapper;
	private final MongoRepository mongoRepository;
	
	public void maria() {
		logger.debug("result: {}", mariaRepository.findAll());
	}
	
	public void mysql() {
		logger.debug("result: {}", mysqlRepository.findAll());
	}
	
	public void db2() {
		logger.debug("result: {}", db2Mapper.selectList("com.doo.skeleton.example.db.mybatis.db2.queryId", null));
	}
	
	public void mongo() {
		logger.debug("result: {}", mongoRepository.findAll());
	}
	
	public void mongoInsert() {
		logger.debug("result: {}", mongoRepository.save(new MongoDto()));
	}
}
