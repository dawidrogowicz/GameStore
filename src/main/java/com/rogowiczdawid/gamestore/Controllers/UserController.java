package com.rogowiczdawid.gamestore.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import com.rogowiczdawid.gamestore.models.User;
import com.rogowiczdawid.gamestore.models.UserDTO;
import com.rogowiczdawid.gamestore.services.UserService;
import com.rogowiczdawid.gamestore.validation.EmailExistsException;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	public void setUserService(UserService us) {
		this.userService = us;
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public String regForm(WebRequest request, Model model) {
		UserDTO userDto = new UserDTO();
		model.addAttribute("user", userDto);
		return "register";
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDTO accountDto, BindingResult result,
			WebRequest request, Errors errors) {
		User registeredUser = new User();
		if (!result.hasErrors())
			registeredUser = createUserAccount(accountDto, result);
		if (registeredUser == null)
			result.rejectValue("email", "message.regError");
		if (result.hasErrors())
			return new ModelAndView("register", "user", accountDto);
		else
			return new ModelAndView("index", "user", accountDto);
	}

	private User createUserAccount(UserDTO accountDto, BindingResult result) {
		User registeredUser = null;
		try {
			registeredUser = userService.registerNewUser(accountDto);
		} catch (EmailExistsException e) {
			return null;
		}
		return registeredUser;
	}
}
