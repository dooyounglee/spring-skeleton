package com.doo.skeleton.db.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
		basePackages = "com.doo.skeleton.example.repository.first",
		entityManagerFactoryRef = "firstEntityManager",
		transactionManagerRef = "firstTransactionManager"
)
public class FirstDataConfig {

	@Autowired
	private Environment env;
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean firstEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource((javax.sql.DataSource) firstDataSource());
		em.setPackagesToScan(new String[] { "com.doo.skeleton.example.dto.db.first" });
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa1.hibernate.ddl-auto"));
        properties.put("hibernate.dialect", env.getProperty("spring.jpa1.hibernate.dialect"));
        properties.put("hibernate.show_sql", Boolean.parseBoolean(env.getProperty("spring.jpa1.show-sql")));
        properties.put("hibernate.format_sql", Boolean.parseBoolean(env.getProperty("spring.jpa1.properties.hibernate.format_sql")));
		em.setJpaPropertyMap(properties);
		em.afterPropertiesSet();
		
		return em;
	}
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource1")
	public DataSource firstDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	@Primary
	public PlatformTransactionManager firstTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(firstEntityManager().getObject());
		return transactionManager;
	}
}
