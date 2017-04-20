package com.rogowiczdawid.gamestore.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rogowiczdawid.gamestore.models.User;
import com.rogowiczdawid.gamestore.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	public void setUserService(UserService us) {
		this.userService = us;
	}

	
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
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String signUp(
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam String rep_password,
			@RequestParam String email ) {
		
		if ((username != null) && (password != null) && (email != null) && password.equals(rep_password)) {
			User u = new User(username, email, password);
			userService.addUser(u);
		}
		
		return "forward:test";
	}
	
	@RequestMapping("/del/{id}")
	public String res(@PathVariable(value="id")int id){
		userService.removeUser(id);
		return "forward:../test";
	}
	

}
