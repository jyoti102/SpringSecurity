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
		return "home.jsp";
	}
}
