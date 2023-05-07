package com.doo.skeleton.db.mybatis;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class Db2Mapper {

	private final SqlSessionTemplate sqlSession;
	
	public Map select(String queryId, Object param) {
		return sqlSession.selectOne(queryId, param);
	}
	
	public List selectList(String queryId, Object param) {
		return sqlSession.selectList(queryId, param);
	}
	
	public Integer insert(String queryId, Object param) {
		return sqlSession.insert(queryId, param);
	}
	
	public Integer delete(String queryId, Object param) {
		return sqlSession.delete(queryId, param);
	}
}
