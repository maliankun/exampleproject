package com.inspur.exampleproject.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspur.exampleproject.entity.DemoTest;
import com.inspur.exampleproject.repository.jdbc.TestJdctDao;
import com.inspur.exampleproject.repository.jpa.DemoTestRepository;
import com.inspur.exampleproject.repository.jpa.UserInfoRepository;
import com.inspur.exampleproject.web.controller.TestController;

@Service
public class TestService {
	
	@Autowired
	DemoTestRepository demoTestRepository;
	@Autowired
	TestJdctDao testJdctDao;
	@Autowired
	UserInfoRepository userInfoRepository;
	
	Logger logger = Logger.getLogger(TestService.class);

	
	public List<DemoTest> getAll(){
		List<DemoTest> all = demoTestRepository.findAll();
		logger.info(all);
		return all;
	}
	
	public List<Map<String,Object>> getAlldata(){
		return testJdctDao.getAlldata();
	}
	
	
	
	
}
