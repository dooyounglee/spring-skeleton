package com.doo.skeleton.common.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.doo.skeleton.common.user.dto.RequestDto;
import com.doo.skeleton.repository.first.user.UserRepository;
import com.doo.skeleton.repository.first.user.vo.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public User register(RequestDto requestDto) {
		User user = requestDto.toUser(requestDto);
		// user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
		return userRepository.save(user);
	}
	
	public User changePassword(RequestDto requestDto) {
		User user = userRepository.findById(requestDto.getId())
				.orElseThrow();
		user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
		return userRepository.save(user);
	}
}
