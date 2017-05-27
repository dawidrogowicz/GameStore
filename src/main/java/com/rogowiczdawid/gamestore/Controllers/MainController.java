package com.rogowiczdawid.gamestore.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String showMain() {
		return "redirect:http://localhost:4200/";
	}
	
	@RequestMapping("/admin")
	@ResponseBody
	public String test() {
		return "admin page";
	}	
}
