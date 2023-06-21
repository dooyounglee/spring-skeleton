package com.doo.skeleton.example.dto;

import org.springframework.stereotype.Component;

import com.doo.skeleton.repository.third.example.vo.ThirdVo;

@Component
public class ThirdMapper {

	public ThirdDto mapToDto(ThirdVo thirdVo) {
		return ThirdDto.builder()
				.id(thirdVo.getId())
				.build();
	}
}
