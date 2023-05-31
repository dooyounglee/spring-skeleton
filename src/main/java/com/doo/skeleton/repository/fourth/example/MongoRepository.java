package com.doo.skeleton.repository.fourth.example;

import org.springframework.stereotype.Repository;

import com.doo.skeleton.repository.fourth.example.vo.MongoDto;

@Repository
public interface MongoRepository extends org.springframework.data.mongodb.repository.MongoRepository<MongoDto, String> {

}
