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

import com.doo.skeleton.db.mybatis.OracleMapper;

@Configuration
@PropertySource({ "classpath:application.properties" })
@MapperScan(
		basePackageClasses = OracleMapper.class,
		sqlSessionFactoryRef="sixthSqlSessionFactory"
)
@EnableTransactionManagement
public class SixthDataConfig {

	@Autowired
	private Environment env;
	
	@Bean(name= "sixthDataSource")
    @ConfigurationProperties(prefix = "spring.datasource6")
    public DataSource sixthDataSource() {
        return DataSourceBuilder.create().build();
    }
 
    @Bean(name= "sixthSqlSessionFactory")
    public SqlSessionFactory sixthSqlSessionFactory(@Qualifier("sixthDataSource") DataSource sixthDataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(sixthDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(env.getProperty("spring.datasource6.mapper.mapperLocations")));
        return sqlSessionFactoryBean.getObject();
    }
 
    @Bean
    public SqlSessionTemplate sixthSqlSessionTemplate(@Qualifier("sixthSqlSessionFactory") SqlSessionFactory sixthSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sixthSqlSessionFactory);
    }
}
