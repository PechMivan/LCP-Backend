package com.lcp.app.service;

import java.util.List;

import com.lcp.app.dto.UserDTO;
import com.lcp.app.dto.UserRegistrationDTO;
import com.lcp.app.entity.User;

public interface UserService {

	User createUser(UserRegistrationDTO user);
	
	User getUserById(Long id);
	
	UserDTO getUserDTOById(Long id);
	
	User getUserByEmail(String email);
	
	UserDTO getUserDTOByEmail(String email);
	
	List<UserDTO> getAllUsers();
	
	User updateUser(User user, Long id);
	
	User deleteUser(Long id);
	
	User loginUser(String email, String password);
	
	List <User> getUsersByName(String name);
	
	List <UserDTO> getUsersDTOByName(String name);
	
	List <User> getUsersByLastName(String lastname);
	
	List <UserDTO> getUsersDTOByLastName(String lastname);
	
}
