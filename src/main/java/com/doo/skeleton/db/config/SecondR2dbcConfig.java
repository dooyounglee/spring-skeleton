package com.doo.skeleton.db.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.r2dbc.core.DefaultReactiveDataAccessStrategy;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.dialect.MySqlDialect;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.core.DatabaseClient;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableR2dbcRepositories(
		basePackages = { "com.doo.skeleton.repository.second" },
		entityOperationsRef = "secondEntityTemplate"
)
public class SecondR2dbcConfig {

	@Autowired
	private Environment env;
	
	@Bean
    @Qualifier(value = "secondConnectionFactory")
    public ConnectionFactory secondConnectionFactory() {
        return ConnectionFactories.get(env.getProperty("spring.r2dbc2.url"));
    }

    @Bean
    public R2dbcEntityOperations secondEntityTemplate(@Qualifier("secondConnectionFactory") ConnectionFactory connectionFactory) {

        DefaultReactiveDataAccessStrategy strategy = new DefaultReactiveDataAccessStrategy(MySqlDialect.INSTANCE);
        DatabaseClient databaseClient = DatabaseClient.builder()
                .connectionFactory(connectionFactory)
                .bindMarkers(MySqlDialect.INSTANCE.getBindMarkersFactory())
                .build();

        return new R2dbcEntityTemplate(databaseClient, strategy);
    }
}
