package com.example.app.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User getUser(long userId) {		
		return userRepository.findById(userId).orElse(null);
	}

	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public List<User> getUnApprovedUsers() {
		final boolean UNAPPROVED = false;
		return userRepository.findByApproved(UNAPPROVED);
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

	public boolean registerUserByAdmin(User user) {
		User existingUser = getUserByUsername(user.getUsername());
		
		if(existingUser == null) {
			userRepository.save(user);
			return false;
		}
		return true;
	}

	public void updateUser(User user) {
		userRepository.save(user);		
	}
	
	public void deleteUser(long userId) {
		userRepository.deleteById(userId);
	}

	public void approveUser(long userId) {
		User existingUser = getUser(userId);
		existingUser.setApproved(true);
		updateUser(existingUser);		
	}

	public void rejectUser(long userId) {
		deleteUser(userId);		
	}
}
