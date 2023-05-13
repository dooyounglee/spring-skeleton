package com.doo.skeleton.config.fourth;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FourthDatasourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.fourth")
    public DataSourceProperties fourthDataSourceProperties() {
        return new DataSourceProperties();
    }
    
    @Bean
	public DataSource fourthDataSource() {
	    return fourthDataSourceProperties()
	      .initializeDataSourceBuilder()
	      .build();
	}
}
