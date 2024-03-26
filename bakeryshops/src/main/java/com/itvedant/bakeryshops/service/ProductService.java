package com.itvedant.bakeryshops.service;



import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itvedant.bakeryshops.GameStoreProperties;
import com.itvedant.bakeryshops.dao.AddProductDao;
import com.itvedant.bakeryshops.dao.CakeDao;
import com.itvedant.bakeryshops.dao.UpdateProductDao;
import com.itvedant.bakeryshops.entity.Product;
import com.itvedant.bakeryshops.entity.Cake;
import com.itvedant.bakeryshops.repository.ProductRepository;
import com.itvedant.bakeryshops.repository.CakeRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	private CakeRepository rideRepository;
	
	private final Path rootLocation;
	public ProductService(GameStoreProperties properties) {
		this.rootLocation=Paths.get(properties.getUploadDir());
		
		try {
			Files.createDirectories(rootLocation);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	


public String storeFile(Integer id,MultipartFile file) {
	try {
		if(file.isEmpty()) {
			System.out.println("Empty f");
		}
		Path destinationFile=this.rootLocation.resolve(Paths.get(file.getOriginalFilename()));
		try(InputStream inputStream=file.getInputStream()){
			Files.copy(inputStream,destinationFile,StandardCopyOption.REPLACE_EXISTING);
			Product product=this.productRepository.findById(id).orElseThrow();
			String fileUploadUrl=ServletUriComponentsBuilder.fromCurrentContextPath()
								.path("/products/download/")
								.path(file.getOriginalFilename())
								.toUriString();
			product.setImageUrl(fileUploadUrl);
			this.productRepository.save(product);
			return "file uploaded succesfully";

	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
}catch(Exception e) {
System.out.println(e.getMessage());	
}
	return "Erro";
}


public Resource loadAsResource(String filename) {
	Path file=rootLocation.resolve(filename);
	try {
		Resource resource=new UrlResource(file.toUri());
		if(resource.exists() || resource.isReadable()) {
			return resource;
		}else {
			System.out.println("File Not dound");
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
	}
	return null;
}

public String createProduct(AddProductDao addproductDao) {
	
	Product product =new Product();
	
	product.setProductName(addproductDao.getProductName());
	product.setDescription(addproductDao.getDescription());
	product.setManufacturer(addproductDao.getManufacturer());
	product.setPrice(addproductDao.getPrice());
	product.setImageUrl(addproductDao.getImageUrl());
	
	this.productRepository.save(product);
	return "product saves";
}

public void deleteProduct(Integer id) {
	this.productRepository.deleteById(id);
}

public void UpdateProductDao(UpdateProductDao updateProductDao, Integer id) {
	
	
	
	Product product = this.productRepository.findById(id).orElse(null);
	
	
	if(updateProductDao.getProductName() != null) {
		product.setProductName(updateProductDao.getProductName());
	}
	
	if(updateProductDao.getManufacturer() != null) {
		product.setManufacturer(updateProductDao.getManufacturer());
	}
	
	if(updateProductDao.getPrice() !=null) {
		product.setPrice(updateProductDao.getPrice());
	}
	
	if(updateProductDao.getDescription() !=null) {
		product.setDescription(updateProductDao.getDescription());
		
	}
	this.productRepository.save(product);
}
}
