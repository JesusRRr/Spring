package com.rolon.spring.rest.SpringRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public UserModel saveUser(@RequestBody UserModel user){
		return userService.saveUser(user);
	}
	
}
