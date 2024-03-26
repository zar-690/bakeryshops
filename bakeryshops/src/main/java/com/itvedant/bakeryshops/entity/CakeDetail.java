package com.itvedant.bakeryshops.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CakeDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String imageUrl;
	private String productName;
	private String firstname;
	private String lastname;
	private Integer mobile;
	private String pickup;
	private String lastpoint;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
	@Override
	public String toString() {
		return "RideDetail [id=" + id + ", imageUrl=" + imageUrl + ", productName=" + productName + ", firstname="
				+ firstname + ", lastname=" + lastname + ", mobile=" + mobile + ", pickup=" + pickup + ", lastpoint="
				+ lastpoint + "]";
	}
	
	
	
	
}
