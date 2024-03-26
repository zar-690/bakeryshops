package com.itvedant.bakeryshops.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cake {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String productname;
	private String firstname;
	private String lastname;
	private Integer mobile;
	private String pickup;
	private String lastpoint;
	private String pickuptime;
	
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getMobile() {
		return mobile;
	}
	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}
	public String getPickup() {
		return pickup;
	}
	public void setPickup(String pickup) {
		this.pickup = pickup;
	}
	public String getLastpoint() {
		return lastpoint;
	}
	public void setLastpoint(String lastpoint) {
		this.lastpoint = lastpoint;
	}
	public String getPickuptime() {
		return pickuptime;
	}
	public void setPickuptime(String pickuptime) {
		this.pickuptime = pickuptime;
	}
	@Override
	public String toString() {
		return "Ride [id=" + id + ", productname=" + productname + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", mobile=" + mobile + ", pickup=" + pickup + ", lastpoint=" + lastpoint + ", pickuptime="
				+ pickuptime + "]";
	}
	

	
	
}
