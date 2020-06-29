package com.rolon.spring.rest.SpringRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rolon.spring.rest.SpringRest.model.UserModel;
import com.rolon.spring.rest.SpringRest.repository.UserRepository;

@Service
public class UserService{
	@Autowired
	UserRepository userRepository;
	
	public List<UserModel> getUsers(){
		return (List<UserModel>) userRepository.findAll();
	}
	
	
}
