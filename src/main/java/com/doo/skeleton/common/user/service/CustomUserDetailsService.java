package com.doo.skeleton.common.user.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.doo.skeleton.repository.first.user.UserRepository;
import com.doo.skeleton.repository.first.user.vo.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		log.debug("userName: {}", userName);
		
		User user = userRepository.findByUserName(userName)
				.orElseThrow(() -> new UsernameNotFoundException("Email " + userName + " not found"));
		log.debug("user: {}", user.getAuthorities());
		
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(),
				user.getPassword(),
				user.getAuthorities()
		);
	}
}
