package com.doo.skeleton.example.dto.db.second;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class MysqlDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
}
