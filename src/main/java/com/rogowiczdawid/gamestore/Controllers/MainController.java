package com.rogowiczdawid.gamestore.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rogowiczdawid.gamestore.models.User;
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
