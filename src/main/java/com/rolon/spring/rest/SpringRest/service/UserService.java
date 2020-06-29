package com.rolon.spring.rest.SpringRest.service;

import java.util.List;
import java.util.Optional;

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
	
	public UserModel saveUser(UserModel user) throws Exception {
		
		if(findByEmail(user.getEmail())==null) {
			return userRepository.save(user);
		}else {
			throw new Exception("User already exist");
		}
	}
	
	public UserModel findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public Optional<UserModel> findById(int id) {
		return userRepository.findById(id);
	}
	
}
