package com.itvedant.bakeryshops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itvedant.bakeryshops.dao.CakeDao;
import com.itvedant.bakeryshops.entity.Cake;
import com.itvedant.bakeryshops.repository.ProductRepository;
import com.itvedant.bakeryshops.repository.CakeRepository;
import com.itvedant.bakeryshops.repository.UserRepository;
import com.itvedant.bakeryshops.service.CakeService;

@Controller
@RequestMapping("/rides")
public class CakeController {

	@Autowired
	private CakeRepository rideRepository;
	
	@Autowired
	private CakeService rideService;

	@Autowired
	private ProductRepository productRepsitory;

	@Autowired
	private UserRepository userrepository;
	
	@GetMapping("/addride")
	public String ride(Model model) {
		model.addAttribute("ride", new Cake());
		return "rideinformation";
	}
	
	@PostMapping("/addride")
	public  ModelAndView riderPost(@ModelAttribute("ride") CakeDao rideDao,Model model) {
		model.addAttribute("ride", rideDao);
		this.rideService.CreateRide(rideDao);
		ModelAndView mav=new ModelAndView("cars");
		mav.addObject("products", this.productRepsitory.findAll());
		return mav;
	
	}	
	
	@GetMapping("/usershow")
	public ModelAndView usershow() {
		ModelAndView mav=new ModelAndView("userinformation");
		mav.addObject("rides", this.rideRepository.findAll());
		return mav;
		
	}
	
}
