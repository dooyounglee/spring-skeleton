package com.doo.skeleton.repository.second.example.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecondVo {

	@Id
    private Long id;
}
