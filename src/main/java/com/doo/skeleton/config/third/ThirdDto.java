package com.doo.skeleton.config.third;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class ThirdDto {

	@Id
	@SequenceGenerator(name = "third_seq", sequenceName = "thirddto_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
