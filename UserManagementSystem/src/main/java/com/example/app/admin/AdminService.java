package com.example.app.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.user.User;
import com.example.app.user.UserService;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private UserService userService;

	public Admin getAdminByUsername(String username) {
		return adminRepository.findByUsername(username);
	}
	
	public boolean loginAdmin(Admin admin) {
		
		Admin existingAdmin = getAdminByUsername(admin.getUsername());
		if(existingAdmin != null) {
			if(existingAdmin.getPassword().equals(admin.getPassword())) {
				return true;
			}
		}
		
		return false;
	}

	public boolean saveUser(User user) {
		user.setApproved(true);
		return userService.registerUserByAdmin(user);		
	}

	public void updateUser(User user) {
		user.setApproved(true);
		userService.updateUser(user);
	}
	
}
