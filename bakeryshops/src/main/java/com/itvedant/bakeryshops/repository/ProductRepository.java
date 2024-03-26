package com.itvedant.bakeryshops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.bakeryshops.entity.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer>{

}
