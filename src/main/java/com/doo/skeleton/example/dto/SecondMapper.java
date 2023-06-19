package com.doo.skeleton.example.dto;

import org.springframework.stereotype.Component;

import com.doo.skeleton.repository.second.example.vo.SecondVo;

@Component
public class SecondMapper {

	public SecondDto mapToDto(SecondVo secondVo) {
		return SecondDto.builder()
				.id(secondVo.getId())
				.build();
	}
}
