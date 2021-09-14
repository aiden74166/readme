package com.test.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

//数据库主从配置,还可以用
@SpringBootApplication
@MapperScan(basePackages = "com.test.datasource.mapper")
@MapperScan(basePackages = "com.test.datasource.mapper2", sqlSessionFactoryRef = "sessionFactory1")

public class DataSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataSourceApplication.class, args);
	}

	@Bean()
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.primary")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Primary
	public SqlSessionFactory sessionFactory() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*Mapper.xml"));
		bean.setDataSource(dataSource());
		return bean.getObject();
	}

	@Bean()
	@ConfigurationProperties(prefix = "spring.datasource.slave")
	public DataSource slavedb() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public SqlSessionFactory sessionFactory1() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*Mapper.xml"));
		bean.setDataSource(slavedb());
		return bean.getObject();
	}
}
