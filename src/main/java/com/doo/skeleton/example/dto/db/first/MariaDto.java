package com.doo.skeleton.example.dto.db.first;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class MariaDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
}
