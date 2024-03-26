package com.itvedant.bakeryshops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.itvedant.bakeryshops.dao.AddProductDao;
import com.itvedant.bakeryshops.dao.UpdateProductDao;
import com.itvedant.bakeryshops.entity.Product;
import com.itvedant.bakeryshops.repository.ProductRepository;
import com.itvedant.bakeryshops.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

@Autowired
private ProductService productService;

@Autowired
private ProductRepository productRepsitory;



@PostMapping("/{id}/upload")
public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file, @PathVariable Integer id){
	return ResponseEntity.ok(this.productService.storeFile(id, file));
}


public ResponseEntity<?> download(@PathVariable String filename){
	Resource resource=this.productService.loadAsResource(filename);
	return ResponseEntity.ok()
			.header(HttpHeaders.CONTENT_DISPOSITION,"attachemnt; filename=\""+filename+"\"").body(resource);
}




@PostMapping("/addproduct")
public String saveProduct(@ModelAttribute("product") AddProductDao addproductDao,Model model) {
	model.addAttribute("product",addproductDao);
	this.productService.createProduct(addproductDao);
	return "showproducts";
}

@GetMapping("/addproduct")
public String create(Model model ) {
	model.addAttribute("product",new Product());
	return "addproduct";
}


@GetMapping("/show")
public ModelAndView show() {
	ModelAndView mav=new ModelAndView("showproducts");
	mav.addObject("products", this.productRepsitory.findAll());
	return mav;
	
}



@GetMapping("/usershow")
public ModelAndView usershow() {
	ModelAndView mav=new ModelAndView("userinformation");
	mav.addObject("products", this.productRepsitory.findAll());
	return mav;
	
}

@GetMapping("/{id}")
public String delete(@PathVariable("id") Integer id) {
	this.productService.deleteProduct(id);
	return "showproducts";
}


@PostMapping("/editproduct/{id}")
public String saveProduct(@ModelAttribute("product") UpdateProductDao updateProductDao ,Model model, @PathVariable("id") Integer id) {
	this.productService.UpdateProductDao(updateProductDao, id);
	Product product=this.productRepsitory.findById(id).orElse(null);
	model.addAttribute("product", product);
	return "showproducts";
}
@GetMapping("/editproduct/{id}")
public String edit(Model model,@PathVariable("id") Integer id) {
	model.addAttribute("product",this.productRepsitory.findById(id));
	return"editproduct";
}

/*
@PostMapping("/editproduct/{id}")
public String saveProduct(@ModelAttribute("product") UpdateProductDao updateProductDao ,Model model, @PathVariable("id") Integer id) {
	this.productService.updateProduct(updateProductDao ,id);
	Product product=this.productRepsitory.findById(id).orElse(null);
	model.addAttribute("product", product);
	return "showproducts";
}*/
}