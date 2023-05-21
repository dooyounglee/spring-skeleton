package com.doo.skeleton.example.repository.second;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doo.skeleton.example.dto.db.second.MysqlDto;

public interface MysqlRepository extends JpaRepository<MysqlDto, Long> {

}
