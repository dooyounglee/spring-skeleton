package com.doo.skeleton.db.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(
		basePackages = { "com.doo.skeleton.repository.second" },
		entityManagerFactoryRef = "secondEntityManager",
		transactionManagerRef = "secondTransactionManager"
)
public class SecondDataConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean secondEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource((javax.sql.DataSource) secondDataSource());
		em.setPackagesToScan(new String[] { "com.doo.skeleton.repository.second" });
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa2.hibernate.ddl-auto"));
        properties.put("hibernate.dialect", env.getProperty("spring.jpa2.hibernate.dialect"));
        properties.put("hibernate.show_sql", Boolean.parseBoolean(env.getProperty("spring.jpa2.show-sql")));
        properties.put("hibernate.format_sql", Boolean.parseBoolean(env.getProperty("spring.jpa2.properties.hibernate.format_sql")));
		em.setJpaPropertyMap(properties);
		em.afterPropertiesSet();
		
		return em;
	}
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource2")
	public DataSource secondDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public PlatformTransactionManager secondTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(secondEntityManager().getObject());
		return transactionManager;
	}
}
