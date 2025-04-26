package com.orm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public int SaveUser(User user) {
		return repo.CreateUser(user);
	}

}
