package com.itvedant.bakeryshops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.bakeryshops.entity.Cake;

@Repository
public interface CakeRepository extends JpaRepository<Cake, Integer> {
	
}
