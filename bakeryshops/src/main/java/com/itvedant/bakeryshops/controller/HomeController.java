package com.itvedant.bakeryshops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itvedant.bakeryshops.entity.Product;
import com.itvedant.bakeryshops.entity.User;
import com.itvedant.bakeryshops.repository.ProductRepository;
import com.itvedant.bakeryshops.service.ProductService;

@Controller
@RequestMapping()
public class HomeController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepsitory;
	
	@GetMapping("/index")
	public ModelAndView show() {
		ModelAndView mav=new ModelAndView("cars");
		mav.addObject("products", this.productRepsitory.findAll());
		return mav;
		
	}
	
	
	
	


}
