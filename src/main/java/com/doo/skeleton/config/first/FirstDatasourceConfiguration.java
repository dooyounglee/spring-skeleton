package com.doo.skeleton.config.first;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirstDatasourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.first")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }
    
    @Bean
	public DataSource firstDataSource() {
	    return firstDataSourceProperties()
	      .initializeDataSourceBuilder()
	      .build();
	}
}