package com.inspur.exampleproject.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.inspur.exampleproject.entity.DemoTest;
import com.inspur.exampleproject.service.TestService;
import com.inspur.exampleproject.util.HeaderUtil2;
import com.inspur.exampleproject.web.resq.UserInfo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class TestController {
	
	@Autowired
	TestService testService;

	
	private AuthenticationManager authenticationManager;
	
	Logger logger = Logger.getLogger(TestController.class);
	
	
	
	public TestController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
	
	@GetMapping("/getAlldata")
	public ResponseEntity<List<DemoTest>> getAlldata(){
		List<DemoTest> alldata = testService.getAll();
		
	    return  ResponseEntity.ok().headers(HeaderUtil2.createOKHeader("OK", "")).body(alldata);
	}
	
	
	@GetMapping("/getAllmap")
	public ResponseEntity<List> getAlldataMap(){
		List<Map<String,Object>> alldata = testService.getAlldata();
		
	    return  ResponseEntity.ok().headers(HeaderUtil2.createOKHeader("OK", "")).body(alldata);
	}
	
	@GetMapping("/toLogin")
	public ModelAndView toLogin(){
		ModelAndView modelView = new ModelAndView("/Hello");
		return modelView;
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<String> login(@RequestBody UserInfo userinfo){
		String aa ="aaa";
		logger.info("打印的信息==="+aa);
		 ArrayList<GrantedAuthority> authorities = new ArrayList<>();
         //authorities.add( new GrantedAuthorityImpl("ROLE_ADMIN"));
         //authorities.add( new GrantedAuthorityImpl("AUTH_WRITE"));
         // 生成令牌 这里令牌里面存入了:name,password,authorities, 当然你也可以放其他内容
         
         User user = new User(userinfo.getUsername(),userinfo.getPassword(),new ArrayList<>());
         
         Authentication auth = new UsernamePasswordAuthenticationToken(user, userinfo.getPassword(), authorities);
         
         Authentication authentication = this.authenticationManager.authenticate(auth);
         SecurityContextHolder.getContext().setAuthentication(authentication);
         String token = Jwts.builder()
                 .setSubject(((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername())
                 .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
                 .signWith(SignatureAlgorithm.HS512, "MyJwtSecret")
                 .compact();
         
         
         
		return ResponseEntity.ok().body(token);
		
	}
	

}
