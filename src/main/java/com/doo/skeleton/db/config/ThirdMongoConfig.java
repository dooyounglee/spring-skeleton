package com.doo.skeleton.db.config;

import static java.util.Collections.singletonList;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableReactiveMongoRepositories(
		basePackages = { "com.doo.skeleton.repository.third" },
		reactiveMongoTemplateRef = "thirdReactiveMongoTemplate"
)
public class ThirdMongoConfig {

	@Bean
	@Primary
	public ReactiveMongoDatabaseFactory thirdReactiveMongoDatabaseFactory(
			@Qualifier("thirdMongoClient") MongoClient mongoClient,
			@Qualifier("thirdMongoSource") MongoProperties mongoProperties
			) {
		return new SimpleReactiveMongoDatabaseFactory(mongoClient, mongoProperties.getDatabase());
	}
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.data.mongodb1")
	public MongoProperties thirdMongoSource() {
		return new MongoProperties();
	}
	
	@Bean
	public MongoClient thirdMongoClient(@Qualifier("thirdMongoSource") MongoProperties mongoProperties) {
		MongoCredential credential = MongoCredential.createCredential(
				mongoProperties.getUsername(),
				mongoProperties.getAuthenticationDatabase(),
				mongoProperties.getPassword());
				
		return MongoClients.create(MongoClientSettings.builder()
			   .applyToClusterSettings(builder -> builder
					   .hosts(singletonList(new ServerAddress(mongoProperties.getHost(), mongoProperties.getPort()))))
			   .credential(credential)
			   .build());
	}
	
	@Bean
	public ReactiveMongoTemplate thirdReactiveMongoTemplate(@Qualifier("thirdReactiveMongoDatabaseFactory") ReactiveMongoDatabaseFactory thirdReactiveMongoDatabaseFactory){
		return new ReactiveMongoTemplate(thirdReactiveMongoDatabaseFactory);
	}
}
