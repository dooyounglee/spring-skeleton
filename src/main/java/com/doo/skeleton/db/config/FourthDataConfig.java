package com.doo.skeleton.db.config;

import static java.util.Collections.singletonList;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableMongoRepositories(
		basePackages = "com.doo.skeleton.repository.fourth",
		mongoTemplateRef = "forthMongoTemplate"
)
public class FourthDataConfig {

	@Bean
	@Primary
	public MongoDatabaseFactory fourthMongoDatabaseFactory(
			@Qualifier("fourthMongoClient") MongoClient mongoClient,
			@Qualifier("fourthDataSource") MongoProperties mongoProperties
			) {
		return new SimpleMongoClientDatabaseFactory(mongoClient, mongoProperties.getDatabase());
	}
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource4")
	public MongoProperties fourthDataSource() {
		return new MongoProperties();
	}
	
	@Bean
	public MongoClient fourthMongoClient(@Qualifier("fourthDataSource") MongoProperties mongoProperties) {
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
	public MongoTemplate forthMongoTemplate(@Qualifier("fourthMongoDatabaseFactory") MongoDatabaseFactory mongoDatabaseFactory) {
		return new MongoTemplate(mongoDatabaseFactory);
	}
}
