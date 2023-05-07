package com.doo.skeleton.example.dto.db.fourth;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "mongdoDto")
@Data
public class MongoDto {

	@Id private String id;
}
