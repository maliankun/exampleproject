package com.inspur.exampleproject.jwt;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserAuthProvider implements AuthenticationProvider{
	
	private UserDetailsService userDetailsService;
	
	public UserAuthProvider(UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		  String name = authentication.getName();
	        String password = authentication.getCredentials().toString();
	        // 认证逻辑
	        UserDetails userDetails = userDetailsService.loadUserByUsername(name);
	        if (null != userDetails) {
	            if (password.equals(userDetails.getPassword())) {
	                // 这里设置权限和角色
	                ArrayList<GrantedAuthority> authorities = new ArrayList<>();
	                //authorities.add( new GrantedAuthorityImpl("ROLE_ADMIN"));
	                //authorities.add( new GrantedAuthorityImpl("AUTH_WRITE"));
	                // 生成令牌 这里令牌里面存入了:name,password,authorities, 当然你也可以放其他内容
	                
	                User user = new User(name,password,new ArrayList<>());
	                
	                Authentication auth = new UsernamePasswordAuthenticationToken(user, password, authorities);
	                return auth;
	            } else {
	                throw new BadCredentialsException("密码错误");
	            }
	        } else {
	            throw new UsernameNotFoundException("用户不存在");
	        }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
