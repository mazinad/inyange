package com.inyange.inyange.service;

import java.util.List;
import com.inyange.inyange.helper.RegistrationRequest;
import com.inyange.inyange.model.User;


public interface UserService{
	User save(RegistrationRequest registrationDto);
	void updatePassword(User user);
	User findByEmail(String email);
	User getUserById(long id);
	List<User> findAllUsers();
}
