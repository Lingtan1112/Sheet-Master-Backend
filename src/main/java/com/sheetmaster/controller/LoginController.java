package com.sheetmaster.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@GetMapping("/")
	public String welcomeScreen() {
		System.out.println("Welcome Screen");
		return "<h1>Successfully Logged In</h1><button>Logout</button>";
//		document.location.href = "https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://localhost:4300/";
	}


}
