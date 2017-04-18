package com.rogowiczdawid.gamestore.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rogowiczdawid.gamestore.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	public void setUserService(UserService us) {
		this.userService = us;
	}

	
	

}
