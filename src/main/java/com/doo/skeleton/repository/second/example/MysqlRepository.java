package com.doo.skeleton.repository.second.example;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doo.skeleton.repository.second.example.vo.MysqlDto;

public interface MysqlRepository extends JpaRepository<MysqlDto, Long> {

}
