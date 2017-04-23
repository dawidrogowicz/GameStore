package com.rogowiczdawid.gamestore.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rogowiczdawid.gamestore.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	public void setUserService(UserService us) {
		this.userService = us;
	}
	
	@RequestMapping(value = "/sign_in", method = RequestMethod.POST)
	public String signIn(
			@RequestParam String username,
			@RequestParam String password){
		
		
		
		return "forward:./";
	}
}
