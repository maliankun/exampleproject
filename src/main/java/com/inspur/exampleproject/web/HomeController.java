package com.inspur.exampleproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class HomeController {

	
	
	@RequestMapping("/{url}")
	public String mainPage(@PathVariable("url") String url){
		
		
		return url;
	}
	
}
