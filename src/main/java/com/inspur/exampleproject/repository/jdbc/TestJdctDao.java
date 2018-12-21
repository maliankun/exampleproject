package com.inspur.exampleproject.repository.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestJdctDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<Map<String,Object>> getAlldata(){
		String sql="select * from DEMO_TEST";
		return jdbcTemplate.queryForList(sql);
	}
	
	
}
