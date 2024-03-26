package com.itvedant.bakeryshops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.bakeryshops.entity.CakeDetail;

@Repository
public interface CakeDetailRepository extends JpaRepository<CakeDetail, Integer>{

}
