package com.doo.skeleton.config.third;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThirdDatasourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.third")
    public DataSourceProperties thirdDataSourceProperties() {
        return new DataSourceProperties();
    }
    
    @Bean
	public DataSource thirdDataSource() {
	    return thirdDataSourceProperties()
	      .initializeDataSourceBuilder()
	      .build();
	}
}
