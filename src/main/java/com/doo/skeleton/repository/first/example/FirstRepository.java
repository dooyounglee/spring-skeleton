package com.doo.skeleton.repository.first.example;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.doo.skeleton.repository.first.example.vo.FirstVo;

public interface FirstRepository extends R2dbcRepository<FirstVo, Long> {

}
