package com.doo.skeleton.db.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource({ "classpath:application.properties" })
@MapperScan(value="com.doo.skeleton.db.mybatis", sqlSessionFactoryRef="thirdSqlSessionFactory")
@EnableTransactionManagement
public class ThirdDataConfig {

	@Autowired
	private Environment env;
	
	@Bean
    @ConfigurationProperties(prefix = "spring.datasource3")
    public DataSource thirdDataSource() {
        return DataSourceBuilder.create().build();
    }
 
    @Bean
    public SqlSessionFactory thirdSqlSessionFactory(@Qualifier("thirdDataSource") DataSource thirdDataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(thirdDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(env.getProperty("spring.datasource3.mapper.mapperLocations")));
        return sqlSessionFactoryBean.getObject();
    }
 
    @Bean
    public SqlSessionTemplate thirdSqlSessionTemplate(SqlSessionFactory thirdSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(thirdSqlSessionFactory);
    }
}
