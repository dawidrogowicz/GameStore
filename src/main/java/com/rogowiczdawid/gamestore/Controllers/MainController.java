package com.rogowiczdawid.gamestore.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
				

	@RequestMapping("/")
	public String showMain() {
		return "index";
	}
			
}
