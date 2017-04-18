package com.rogowiczdawid.gamestore.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rogowiczdawid.gamestore.models.User;
import com.rogowiczdawid.gamestore.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;
		
	@RequestMapping("/test")
	@ResponseBody
	public String ser(){
		List<User> l;
		l = userService.getUsersList();
		String s = "";
		for(User u : l){
			s += u.getUsername()+" "+u.getReg_date()+"   ";
		}
		if(s != "")	return s;
		else return "nope";
	}
	

	@RequestMapping("/")
	public String showMain() {
		return "main_site";
	}

	@RequestMapping("/sign_in")
	public String signIn(Model model, @RequestParam(required = true) String username,
			@RequestParam(required = true) String password) {

		if (username != null && password != null) {
				if (username.equals("admin") && password.equals("root")){
					model.addAttribute("loggedIn", true);
					model.addAttribute("username", username);
				}
		}

		return "main_site";
	}
	
	@RequestMapping("/sign_up")
	public String signUp() {
		return "sign_up";
	}

}
