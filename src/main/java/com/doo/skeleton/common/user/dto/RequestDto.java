package com.doo.skeleton.common.user.dto;

import com.doo.skeleton.repository.first.user.vo.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestDto {

	private Long id;
	@Email
    private String email;
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    
	public User toUser(RequestDto requestDto) {
		User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setUserName(requestDto.getUserName());
        user.setPassword(requestDto.getPassword());
        user.setRole("ROLE_USER");
        return user;
	}
}
