package com.doo.skeleton.repository.second.example;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.doo.skeleton.repository.second.example.vo.SecondVo;

public interface SecondRepository extends R2dbcRepository<SecondVo, Long> {

}
