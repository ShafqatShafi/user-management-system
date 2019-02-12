package com.example.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user-registration")
	public String showUserRegistration(Model model) {
		model.addAttribute("user", new User());
		
		return "user-registration";
	}

	@PostMapping("/user-registration")
	public String registerUser(@ModelAttribute User user, Model model) {
		boolean userAlreadyExists = userService.registerUser(user);
		if(userAlreadyExists) {
			model.addAttribute("error", true);
			return "user-registration";
		}
		
		model.addAttribute("approval", false);
		model.addAttribute("user", new LoginUser());
		return "user-login";
	}

	@GetMapping("/user-login")
	public String showUserLogin(Model model) {
		model.addAttribute("user", new LoginUser());
		return "user-login";
	}
	
	@PostMapping("/user-login")
	public String loginUser(@ModelAttribute LoginUser user, Model model) {
		boolean isUserValid = userService.loginUser(user);
		if(!isUserValid) {
			model.addAttribute("error", true);
			model.addAttribute("user", new LoginUser());
			return "user-login";
		}
		
		String username = user.getUsername();
		User currentUser = userService.getUserByUsername(username);
		if(!currentUser.isApproved()) {
			model.addAttribute("approved", false);
			model.addAttribute("user", new LoginUser());
			return "user-login";
		}
		
		return "redirect:/user-dashboard/"+username;
	}
	
	@GetMapping("/user-dashboard/{username}")
	public String showUserDashboard(@PathVariable String username, Model model) {
		User user = userService.getUserByUsername(username);
		model.addAttribute("user", user);
		
		return "user-dashboard";
	}
	
	@GetMapping("/user-update/{userId}")
	public String showUserUpdate(@PathVariable long userId, Model model) {
		User existingUser = userService.getUser(userId);
		model.addAttribute("user", existingUser);
		
		return "user-update";
	}
	
	@PostMapping("/user-update")
	public String updateuser(@ModelAttribute User user) {
		userService.updateUser(user);
		
		String username = user.getUsername();
		return "redirect:/user-dashboard/"+username;
	}
}
