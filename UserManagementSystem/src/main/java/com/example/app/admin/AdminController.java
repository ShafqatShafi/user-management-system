package com.example.app.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.user.User;
import com.example.app.user.UserService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/admin-login")
	public String showAdminLogin(Model model) {
		model.addAttribute("admin", new Admin());
		
		return "admin-login";
	}
	
	@PostMapping("/admin-login")
	public String loginAdmin(@ModelAttribute Admin admin, Model model) {
		boolean isAdminValid = adminService.loginAdmin(admin);
		if(!isAdminValid) {
			model.addAttribute("error", true);
			model.addAttribute("admin", new Admin());
			return "admin-login";
		}
		return "redirect:/admin-dashboard";
	}
	
	@GetMapping("/admin-dashboard")
	public String showAdminDashboard(Model model) {
		List<User> unApprovedUsers = userService.getUnApprovedUsers();
				
		model.addAttribute("users", unApprovedUsers);
		
		return "admin-dashboard";
	}
	
	@GetMapping("/approve/{userId}")
	public String approveUser(@PathVariable long userId, Model model) {
		userService.approveUser(userId);
		
		return "redirect:/admin-dashboard";
	}
	
	@GetMapping("/reject/{userId}")
	public String rejectUser(@PathVariable long userId, Model model) {
		userService.rejectUser(userId);
		
		return "redirect:/admin-dashboard";
	}

	@GetMapping("/users")
	public String showAllUsers(Model model) {
		List<User> users = userService.getAllUsers();
		
		model.addAttribute("users", users);
		
		return "admin-all-users";
	}
	
	@GetMapping("/admin-user-registration")
	public String showAdminUserRegistration(Model model) {
		model.addAttribute("user", new User());
		
		return "admin-user-registration";
	}

	@PostMapping("/admin-user-registration")
	public String adminUserRegistration(@ModelAttribute User user, Model model) {
		boolean userAlreadyExists = adminService.saveUser(user);
		if(userAlreadyExists) {
			model.addAttribute("error",	true);
			model.addAttribute("user", new User());
			
			return "admin-user-registration";
		}
		return "redirect:/users";
	}

	@GetMapping("/admin-user-update/{userId}")
	public String showAdminUserUpdate(@PathVariable long userId, Model model) {
		User existingUser = userService.getUser(userId);
		model.addAttribute("user", existingUser);
		
		return "admin-user-update";
	}

	@PostMapping("/admin-user-update")
	public String adminUserUpdate(@ModelAttribute User user) {
		adminService.updateUser(user);
		
		return "redirect:/users";
	}

}
