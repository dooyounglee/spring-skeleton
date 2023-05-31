package com.doo.skeleton.repository.fourth.example.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "mongoDto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MongoDto {

	@Id private String id;
}
