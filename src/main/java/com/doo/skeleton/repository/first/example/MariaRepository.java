package com.doo.skeleton.repository.first.example;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doo.skeleton.repository.first.example.vo.MariaDto;

public interface MariaRepository extends JpaRepository<MariaDto, Integer> {

}
