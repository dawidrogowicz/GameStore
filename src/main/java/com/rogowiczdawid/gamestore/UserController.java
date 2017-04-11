package com.rogowiczdawid.gamestore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rogowiczdawid.gamestore.entities.User;
import com.rogowiczdawid.gamestore.services.UserService;

@Controller
public class UserController {

	@Autowired(required = true)
	@Qualifier(value="userService")
	UserService userService;

	public void setUserService(UserService us) {
		this.userService = us;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getUsersList(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("usersList", userService.getUsersList());
		return "user";
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User u) {
		if (u.getId() == 0)
			this.userService.addUser(u);
		else
			this.userService.updateUser(u);
		return "redirect:/users";
	}

	@RequestMapping("/remove/{id}")
	public String removeUser(@PathVariable("id") int id) {
		this.removeUser(id);
		return "redirect:/users";
	}

	@RequestMapping("/edit/{id}")
	public String editUser(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", this.userService.getUser(id));
		model.addAttribute("userList", this.userService.getUsersList());
		return "user";
	}

}
