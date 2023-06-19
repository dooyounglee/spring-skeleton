package com.doo.skeleton.example.dto;

import org.springframework.stereotype.Component;

import com.doo.skeleton.repository.first.example.vo.FirstVo;

@Component
public class FirstMapper {

	public FirstDto mapToDto(FirstVo firstVo) {
		return FirstDto.builder()
				.id(firstVo.getId())
				.build();
	}
}
