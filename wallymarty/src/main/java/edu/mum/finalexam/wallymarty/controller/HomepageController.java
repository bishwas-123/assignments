package edu.mum.finalexam.wallymarty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomepageController {

	@RequestMapping(value={"/", "/wallmarty", "wallmarty/home","wallMarty","wallmart","Wallmart", "home"},
			method=RequestMethod.GET)
	public String homepage() {
		return "home/index";
	}


//
//	   <dependency>
//            <groupId>org.springframework.security</groupId>
//            <artifactId>spring-security-test</artifactId>
//            <scope>test</scope>
//        </dependency>
	
}