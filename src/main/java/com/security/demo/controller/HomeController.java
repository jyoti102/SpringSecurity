package com.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jyoti Singh
 *
 */
@Controller
public class HomeController {

	/**
	 * @return
	 */
	@RequestMapping("/")
	public String home() {
		return "login.jsp";
	}
	
	@RequestMapping("/home")
	public String homePage() {
		return "home.jsp";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "logout.jsp";
	}
	
	@RequestMapping("/about-us")
	public String aboutUs() {
		return "about-us.jsp";
	}
}
