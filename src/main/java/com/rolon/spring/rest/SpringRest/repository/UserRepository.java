package com.rolon.spring.rest.SpringRest.repository
;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rolon.spring.rest.SpringRest.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer>{
	public abstract UserModel findByEmail(String email);
}
