package com.example.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User getUser(long userId) {
		User user = userRepository.findById(userId).orElse(null);
		
		return user;
	}

	public User getUserByUsername(String username) {
		User user = userRepository.findByUsername(username);
		
		return user;
	}

	
	public boolean loginUser(LoginUser user) {
		
		User existingUser = getUserByUsername(user.getUsername());
		
		if(existingUser != null) {
			if(existingUser.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		
		return false;
	}

	public boolean registerUser(User user) {
		User existingUser = getUserByUsername(user.getUsername());
		
		if(existingUser == null) {
			user.setApproved(false);
			userRepository.save(user);
			return false;
		}
		return true;
	}

	public void updateUser(User user) {
		userRepository.save(user);		
	}
}
