package com.doo.skeleton.config.second;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class SecondDto {

	@Id
	@SequenceGenerator(name = "second_seq", sequenceName = "seconddto_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
