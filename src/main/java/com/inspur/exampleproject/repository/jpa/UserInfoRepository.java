package com.inspur.exampleproject.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inspur.exampleproject.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
	

	UserInfo findByUserAccount(String useraccount);
	
}
