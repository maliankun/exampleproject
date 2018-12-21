package com.inspur.exampleproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.inspur.exampleproject.jwt.Http401AuthenticationEntryPoint;
import com.inspur.exampleproject.jwt.JWTAuthenticationFilter;
import com.inspur.exampleproject.jwt.JWTLoginFilter;
import com.inspur.exampleproject.jwt.NormalLoginFilter;
import com.inspur.exampleproject.jwt.UserAuthProvider;
import com.inspur.exampleproject.service.MyUserDetailService;



/*@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)*/
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MyUserDetailService myUserDetailService;
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .loginProcessingUrl("/authenticate")
            .and()
            .csrf()
            .disable()
            .authorizeRequests()
                .antMatchers("/viewa/*").permitAll()
                .antMatchers("/toLogin").permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(
                        new Http401AuthenticationEntryPoint("Basic realm=\"MyApp\""))
                .and()
                .addFilterBefore(new JWTLoginFilter(authenticationManager()),
                		UsernamePasswordAuthenticationFilter.class)
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
