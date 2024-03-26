package com.itvedant.bakeryshops.dao;


public class UpdateProductDao {
	private String productName;
	private String manufacturer;
	private Integer price;
	private String description;
	private String imageUrl;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "UpdateProductDao [productName=" + productName + ", manufacturer=" + manufacturer + ", price=" + price
				+ ", description=" + description + ", imageUrl=" + imageUrl + "]";
	}
	
}