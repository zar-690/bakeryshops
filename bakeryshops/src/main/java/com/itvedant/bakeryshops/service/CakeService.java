package com.itvedant.bakeryshops.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.bakeryshops.dao.CakeDao;
import com.itvedant.bakeryshops.entity.Cake;
import com.itvedant.bakeryshops.repository.CakeRepository;

@Service
public class CakeService {

	@Autowired
	private CakeRepository rideRepository;
	
	public Cake CreateRide(CakeDao rideDao) {
		
		Cake ride=new Cake();
		ride.setProductname(rideDao.getProductname());
		ride.setPickuptime(rideDao.getPickuptime());
		ride.setFirstname(rideDao.getFirstname());
		ride.setLastname(rideDao.getLastname());
		ride.setMobile(rideDao.getMobile());
		ride.setPickup(rideDao.getPickup());
		ride.setLastpoint(rideDao.getLastpoint());
		this.rideRepository.save(ride);
		return ride;
	}
}
