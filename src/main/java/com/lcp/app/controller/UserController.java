package com.lcp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lcp.app.dto.UserDTO;
import com.lcp.app.dto.UserRegistrationDTO;
import com.lcp.app.entity.User;
import com.lcp.app.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public  ResponseEntity< User > createUser(@RequestBody UserRegistrationDTO user) {
		User newUser = userService.createUser(user);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED); // Status 201
	}
	
	@PostMapping("login")
	public  ResponseEntity< User > loginUser(@RequestBody User user) {
		User existingUser = userService.loginUser(user.getEmail(), user.getPassword());
		return new ResponseEntity<>(existingUser, HttpStatus.OK); // Status 200
	}
	
	@GetMapping("{id}")
	public ResponseEntity< UserDTO > getUserById(@PathVariable Long id){
		UserDTO user = userService.getUserDTOById(id);
		return new ResponseEntity<>(user, HttpStatus.OK); // Status 200
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity< UserDTO > getUserByEmail(@PathVariable String email){
		UserDTO user = userService.getUserDTOByEmail(email);
		return new ResponseEntity<>(user, HttpStatus.OK); // Status 200
	}
	
	@GetMapping
	public ResponseEntity< List<UserDTO> > getAllUsers(){
		List<UserDTO> usersDTO = userService.getAllUsers();
		return new ResponseEntity<>( usersDTO, HttpStatus.OK );
	}
	
	@PutMapping("{id}")
	public ResponseEntity< User > updateUser(@PathVariable Long id,@RequestBody User user){
		User existingUser = userService.updateUser(user, id);
		return new ResponseEntity<>(existingUser, HttpStatus.OK); // Status 200
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity< User > deleteUser(@PathVariable Long id){
		User user = userService.deleteUser(id);
		return new ResponseEntity<>(user, HttpStatus.OK); // Status 200
	}
	
	@GetMapping("name/{name}")
	public ResponseEntity< List <UserDTO> > getUserByName(@PathVariable String name){
		List <UserDTO> users = userService.getUsersDTOByName(name);
		return new ResponseEntity<>(users, HttpStatus.OK); // Status 200
	}
	
	@GetMapping("lastname/{lastname}")
	public ResponseEntity< List <UserDTO> > getUserByLastName(@PathVariable String lastname){
		List <UserDTO> users = userService.getUsersDTOByLastName(lastname);
		return new ResponseEntity<>(users, HttpStatus.OK); // Status 200
	}
	
	
}
