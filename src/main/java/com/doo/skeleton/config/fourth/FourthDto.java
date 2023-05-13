package com.doo.skeleton.config.fourth;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class FourthDto {

	@Id
	@SequenceGenerator(name = "fourth_seq", sequenceName = "fourthdto_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
