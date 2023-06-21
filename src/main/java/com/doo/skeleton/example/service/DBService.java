package com.doo.skeleton.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doo.skeleton.example.dto.FirstDto;
import com.doo.skeleton.example.dto.FirstMapper;
import com.doo.skeleton.example.dto.SecondDto;
import com.doo.skeleton.example.dto.SecondMapper;
import com.doo.skeleton.example.dto.ThirdDto;
import com.doo.skeleton.example.dto.ThirdMapper;
import com.doo.skeleton.repository.first.example.FirstRepository;
import com.doo.skeleton.repository.second.example.SecondRepository;
import com.doo.skeleton.repository.third.example.ThirdRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
@Transactional
public class DBService {

	private final Logger logger = LoggerFactory.getLogger(DBService.class);
	
	private final FirstRepository firstRepository;
	private final SecondRepository secondRepository;
	private final ThirdRepository thirdRepository;
	private final FirstMapper firstMapper;
	private final SecondMapper secondMapper;
	private final ThirdMapper thirdMapper;
	
	
	public Flux<FirstDto> first() {
		logger.debug("com.doo.skeleton.example.service.DBService.first");
		return firstRepository.findAll()
				.map(firstMapper::mapToDto)
				.switchIfEmpty(Flux.empty());
	}
	
	public Flux<SecondDto> second() {
		logger.debug("com.doo.skeleton.example.service.DBService.second");
		return secondRepository.findAll()
				.map(secondMapper::mapToDto)
				.switchIfEmpty(Flux.empty());
	}
	
	public Flux<ThirdDto> third() {
		logger.debug("com.doo.skeleton.example.service.DBService.third");
		return thirdRepository.findAll()
				.map(thirdMapper::mapToDto)
				.switchIfEmpty(Flux.empty());
	}
}
