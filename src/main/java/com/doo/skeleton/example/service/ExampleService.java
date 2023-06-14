package com.doo.skeleton.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.doo.skeleton.example.dto.ResponseDto;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ExampleService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void getVoid() {
		
	}
	
	public ResponseDto get() {
		return new ResponseDto();
	}
	
	public void postVoid() {
		
	}
	
	public ResponseDto post() {
		return new ResponseDto();
	}
	
	public void putVoid() {
		
	}
	
	public ResponseDto put() {
		return new ResponseDto();
	}
	
	public void deleteVoid() {
		
	}
	
	public ResponseDto delete() {
		return new ResponseDto();
	}
}
