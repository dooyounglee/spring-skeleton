package com.doo.skeleton.cmm.user.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.doo.skeleton.repository.first.user.UserRepository;
import com.doo.skeleton.repository.first.user.vo.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("Email " + username + " not found"));
		
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(),
				user.getPassword(),
				user.getAuthorities()
		);
	}

}
