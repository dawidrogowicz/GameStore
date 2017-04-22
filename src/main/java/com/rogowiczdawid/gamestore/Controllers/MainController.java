package com.rogowiczdawid.gamestore.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rogowiczdawid.gamestore.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;
			

	@RequestMapping("/")
	public String showMain() {
		return "main_site";
	}
	
	@RequestMapping("/sign_up")
	public String fuck(){
		return "sign_up";
	}

}
