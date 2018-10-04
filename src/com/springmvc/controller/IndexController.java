package com.springmvc.controller;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	
	@RequestMapping("/about")
	public String showAblout() throws Exception {
		if(true){
			throw new Exception();
		}
		return "about";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "/";
	}
	
}
