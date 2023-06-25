package com.doo.skeleton.common.user.dto;

import com.doo.skeleton.repository.first.user.vo.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto {

	private User user; 
}
