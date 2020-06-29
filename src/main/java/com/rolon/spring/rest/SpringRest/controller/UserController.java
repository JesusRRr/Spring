package com.rolon.spring.rest.SpringRest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rolon.spring.rest.SpringRest.model.UserModel;
import com.rolon.spring.rest.SpringRest.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping()
	public List<UserModel> getUsers(){
		return userService.getUsers();
	}
	
	@PostMapping()
	public UserModel saveUser(@RequestBody UserModel user) throws Exception{
		try {
			return userService.saveUser(user);
		}catch(Exception e) {
			return user;
		}
		
	}
	@GetMapping(path="/{email}")
	public Optional<UserModel> findByEmail(@PathVariable("email") String email){
		return Optional.of(userService.findByEmail(email));
	}
	
	@GetMapping(path="/{id}")
	public Optional<UserModel> findById(@PathVariable("id") String email){
		return Optional.of(userService.findByEmail(email));
	}
	
	@DeleteMapping(path="/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		if(userService.deleteUser(id)) {
			return new StringBuilder("User with id: ")
					.append(id)
					.append(" deleted")
					.toString();
		}else {
			return new StringBuilder("User with id: ")
					.append(id)
					.append(" wasn't deleted")
					.toString();
		}
		
	}
}
