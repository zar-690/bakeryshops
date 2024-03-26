package com.itvedant.bakeryshops.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itvedant.bakeryshops.dao.RegisterDao;
import com.itvedant.bakeryshops.entity.User;
import com.itvedant.bakeryshops.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCyrptPasswordEncoder;
	
	public User CreateUser(RegisterDao registerDao) {
		
		if(this.userRepository.findByEmail(registerDao.getEmail()).isPresent()){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"user with email already exist");
		}
		
		User user=new User();
		user.setFirstName(registerDao.getFirstName());
		user.setLastName(registerDao.getLastName());
		user.setPassword(bCyrptPasswordEncoder.encode(registerDao.getPassword()));
		user.setEmail(registerDao.getEmail());
		user.setMobile(registerDao.getMobile());
		user.setRoles(registerDao.getRoles());
		
		this.userRepository.save(user);
		return user;
		
	}
}
