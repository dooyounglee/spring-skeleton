package com.doo.skeleton.config.second;

import java.util.HashMap;
import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  basePackageClasses = SecondDto.class,
  entityManagerFactoryRef = "secondEntityManagerFactory",
  transactionManagerRef = "secondTransactionManager"
)
public class SecondJpaConfiguration {

	@Bean
    public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(
      @Qualifier("secondDataSource") DataSource dataSource,
      @Qualifier("secondBuilder") EntityManagerFactoryBuilder builder) {
        return builder
          .dataSource(dataSource)
          .packages(SecondDto.class)
          .build();
    }

    @Bean
    public PlatformTransactionManager secondTransactionManager(
      @Qualifier("secondEntityManagerFactory") LocalContainerEntityManagerFactoryBean secondEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(secondEntityManagerFactory.getObject()));
    }
    
    @Bean
    public EntityManagerFactoryBuilder secondBuilder(Environment env) {
    	HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.dialect", env.getProperty("spring.datasource.second.hibernate.dialect"));
        properties.put("hibernate.show_sql", Boolean.parseBoolean(env.getProperty("spring.jpa.show-sql")));
        properties.put("hibernate.format_sql", Boolean.parseBoolean(env.getProperty("spring.jpa.properties.hibernate.format_sql")));
        return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), properties, null);
    }
}
