package com.src.jpa.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.src.jpa.sample.repositories.custom.impl.query.SqlQuery;

@Configuration
@ComponentScan(basePackages = { "com.src.jpa.sample" })
public class AppConfig {

	@Bean
	public SqlQuery sqlQuery() {
		return new SqlQuery();
	}
}
