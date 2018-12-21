package com.inspur.exampleproject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inspur.exampleproject.entity.UserInfo;
import com.inspur.exampleproject.repository.jpa.UserInfoRepository;
/**
 * spring security 用户详情的service
 * @author liyakun
 */
@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	UserInfoRepository userinfoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserDetails userDetails = null;
		UserInfo userInfo = userinfoRepository.findByUserAccount(username);
		if(null==userInfo){
			throw new UsernameNotFoundException("authentication failed");
		}
		userDetails = new User(userInfo.getUserAccount(), userInfo.getPassWord(), new ArrayList<>());
		
		return userDetails;
	}

}
