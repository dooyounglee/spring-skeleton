package com.doo.skeleton.config.first;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstRepository extends JpaRepository<FirstDto, Long>{

}
