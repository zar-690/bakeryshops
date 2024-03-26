package com.itvedant.bakeryshops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.bakeryshops.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders,Integer> {

}
