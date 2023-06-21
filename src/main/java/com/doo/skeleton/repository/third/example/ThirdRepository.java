package com.doo.skeleton.repository.third.example;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.doo.skeleton.repository.third.example.vo.ThirdVo;

public interface ThirdRepository extends ReactiveCrudRepository<ThirdVo, String>{

}
