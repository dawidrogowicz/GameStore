package com.rogowiczdawid.gamestore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping("/")
	public String showMain() {
		return "main_site";
	}

	@RequestMapping("/sign_in")
	public String signIn(Model model, @RequestParam(required = false) String username,
			@RequestParam(required = false) String password) {

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
