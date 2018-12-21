package com.inspur.exampleproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.inspur.exampleproject.jwt.Http401AuthenticationEntryPoint;
import com.inspur.exampleproject.jwt.JWTAuthenticationFilter;
import com.inspur.exampleproject.jwt.JWTLoginFilter;
import com.inspur.exampleproject.jwt.UserAuthProvider;
import com.inspur.exampleproject.service.MyUserDetailService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class NoBeforeWebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MyUserDetailService myUserDetailService;
	
	
	
	
	
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .disable()
            .csrf()
            .disable()
            .authorizeRequests()
                .antMatchers("/viewa/*").permitAll()
                .antMatchers("/toLogin").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/authenticate").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(
                        new Http401AuthenticationEntryPoint("Basic realm=\"MyApp\""))
                .and()
                .addFilter(new JWTLoginFilter(authenticationManager()))
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
            .logout()
                .permitAll();
    }
 
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new UserAuthProvider(myUserDetailService));
    }

}
