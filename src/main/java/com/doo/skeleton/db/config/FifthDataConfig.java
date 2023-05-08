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

import com.doo.skeleton.db.mybatis.MariaMapper;

@Configuration
@PropertySource({ "classpath:application.properties" })
@MapperScan(
		basePackageClasses = MariaMapper.class,
		sqlSessionFactoryRef="fifthSqlSessionFactory"
)
@EnableTransactionManagement
public class FifthDataConfig {

	@Autowired
	private Environment env;
	
	@Bean(name= "fifthDataSource")
    @ConfigurationProperties(prefix = "spring.datasource5")
    public DataSource fifthDataSource() {
        return DataSourceBuilder.create().build();
    }
 
    @Bean(name= "fifthSqlSessionFactory")
    public SqlSessionFactory fifthSqlSessionFactory(@Qualifier("fifthDataSource") DataSource fifthDataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(fifthDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(env.getProperty("spring.datasource5.mapper.mapperLocations")));
        return sqlSessionFactoryBean.getObject();
    }
 
    @Bean
    public SqlSessionTemplate fifthSqlSessionTemplate(@Qualifier("fifthSqlSessionFactory") SqlSessionFactory fifthSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(fifthSqlSessionFactory);
    }
}
