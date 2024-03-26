package com.itvedant.bakeryshops.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.itvedant.bakeryshops.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@RestResource(exported=false)  // used to store internaly in code not in url beace of this we used that
	Optional<User> findByEmail(String email);
	
	@RestResource(exported=false)  
	<S extends User> S save(S entity); // userd to store the resources
}
