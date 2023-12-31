package com.inyange.inyange.service;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.inyange.inyange.helper.RegistrationRequest;
import com.inyange.inyange.model.Role;
import com.inyange.inyange.model.User;
import com.inyange.inyange.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	private User user;
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	

	@Override
	public User save(RegistrationRequest registrationDto) {
		User user = new User(registrationDto.getFullName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()),
				Arrays.asList(new Role("USER")));
		
		return userRepository.save(user);
	}
	 @Override
	    public User findByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }
	  @Override
	    @Modifying
	    public void updatePassword(User user) {
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        userRepository.save(user);
	    }
		public boolean hasRole(String roleName) {
		return user.hasRole(roleName);
	}
	@Override
	public User getUserById(long id) {
		Optional<User>optional=userRepository.findById(id);
		User user =null;
		if(optional.isPresent()) {
			user=optional.get();
		}else {
			throw new RuntimeException("User Not FOund with this "+id);
		}
		return user;
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}


}
