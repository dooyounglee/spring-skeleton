package com.doo.skeleton.example.repository.fourth;

import org.springframework.stereotype.Repository;

import com.doo.skeleton.example.dto.db.fourth.MongoDto;

@Repository
public interface MongoRepository extends org.springframework.data.mongodb.repository.MongoRepository<MongoDto, String> {

}
