package com.inspur.exampleproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class JdbcConfig {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(){
		return new NamedParameterJdbcTemplate(jdbcTemplate);
	}

	
	
}
