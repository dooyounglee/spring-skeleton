package com.doo.skeleton.example.repository.first;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doo.skeleton.example.dto.db.first.MariaDto;

public interface MariaRepository extends JpaRepository<MariaDto, Long> {

}
