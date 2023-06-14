package com.doo.skeleton.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.doo.skeleton.db.mybatis.Db2Mapper;
import com.doo.skeleton.db.mybatis.MariaMapper;
import com.doo.skeleton.db.mybatis.OracleMapper;
import com.doo.skeleton.example.dto.RequestDto;
import com.doo.skeleton.repository.first.example.MariaRepository;
import com.doo.skeleton.repository.first.message.MessageRepository;
import com.doo.skeleton.repository.first.message.vo.Message;
import com.doo.skeleton.repository.fourth.example.MongoRepository;
import com.doo.skeleton.repository.fourth.example.vo.MongoDto;
import com.doo.skeleton.repository.second.example.MysqlRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class DBService {
	
	private final Logger logger = LoggerFactory.getLogger(DBService.class);

	private final MariaRepository mariaRepository;
	private final MariaMapper mariaMapper;
	private final MysqlRepository mysqlRepository;
	private final Db2Mapper db2Mapper;
	private final MongoRepository mongoRepository;
	private final OracleMapper oracleMapper;
	private final MessageRepository messageRepository;
	
	public void maria() {
		logger.debug("result: {}", mariaRepository.findAll());
	}
	
	public void mariaMybatis() {
		logger.debug("result: {}", mariaMapper.selectList("com.doo.skeleton.db.mybatis.MariaMapper.queryId", null));
	}
	
	public void mysql() {
		logger.debug("result: {}", mysqlRepository.findAll());
	}
	
	public void db2() {
		logger.debug("result: {}", db2Mapper.selectList("com.doo.skeleton.db.mybatis.Db2Mapper.queryId", null));
	}
	
	public void mongo() {
		logger.debug("result: {}", mongoRepository.findAll());
	}
	
	public void mongoInsert() {
		logger.debug("result: {}", mongoRepository.save(new MongoDto()));
	}
	
	public void oracleMybatis() {
		logger.debug("result: {}", oracleMapper.selectList("com.doo.skeleton.db.mybatis.OracleMapper.queryId", null));
	}

	public void transaction() {
		messageRepository.save(new Message("CM-0099","그만해","ko_KR","N"));
		mariaMapper.insert("com.doo.skeleton.db.mybatis.MariaMapper.insert", null);
	}
	
	public void example(RequestDto requestDto) {
		mariaMapper.select("com.doo.skeleton.db.mybatis.MariaMapper.select", requestDto);
		mariaMapper.selectList("com.doo.skeleton.db.mybatis.MariaMapper.selectList", requestDto);
		mariaMapper.insert("com.doo.skeleton.db.mybatis.MariaMapper.insert", requestDto);
		mariaMapper.update("com.doo.skeleton.db.mybatis.MariaMapper.update", requestDto);
		mariaMapper.delete("com.doo.skeleton.db.mybatis.MariaMapper.delete", requestDto);
	}
}
