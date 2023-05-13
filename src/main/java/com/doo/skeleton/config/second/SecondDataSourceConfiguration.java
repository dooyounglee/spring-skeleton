package com.doo.skeleton.config.second;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondDataSourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.second")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }
    
    @Bean
	public DataSource secondDataSource() {
	    return secondDataSourceProperties()
	      .initializeDataSourceBuilder()
	      .build();
	}
}
