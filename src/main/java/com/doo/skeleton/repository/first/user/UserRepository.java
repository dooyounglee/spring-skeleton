package com.doo.skeleton.repository.first.user;

import java.util.Optional;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.doo.skeleton.repository.first.user.vo.User;

public interface UserRepository extends R2dbcRepository<User, Long>{

	Optional<User> findByUserName(String userName);
}
