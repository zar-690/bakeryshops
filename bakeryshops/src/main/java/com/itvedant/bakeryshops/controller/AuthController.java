package com.itvedant.bakeryshops.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itvedant.bakeryshops.dao.LoginDao;
import com.itvedant.bakeryshops.dao.RegisterDao;
import com.itvedant.bakeryshops.dao.CakeDao;
import com.itvedant.bakeryshops.entity.Cake;
import com.itvedant.bakeryshops.entity.User;
import com.itvedant.bakeryshops.repository.ProductRepository;
import com.itvedant.bakeryshops.repository.UserRepository;
import com.itvedant.bakeryshops.service.CakeService;
import com.itvedant.bakeryshops.service.UserService;


@Controller
@RequestMapping("/users")
public class AuthController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductRepository productRepsitory;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CakeService rideService;

	@Autowired
	private UserRepository userrepository;

	
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody RegisterDao resiRegisterDao){
		return ResponseEntity.ok(this.userService.CreateUser(resiRegisterDao));
	}
	
	@GetMapping("/login")
	public String log(Model model) {
		model.addAttribute("user",new User());
		return "logins";
	}
	
	
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("user") LoginDao loginDao, Model model) {
		model.addAttribute("user",loginDao);
		Authentication authentication=authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDao.getEmail(),
														loginDao.getPassword()));
						
				SecurityContextHolder.getContext().setAuthentication(authentication);
				
				ModelAndView mav=new ModelAndView("cars");
				mav.addObject("products", this.productRepsitory.findAll());
				return mav;
	    
	}
	
	@GetMapping("/home")
	public String logs(Model model) {
		return "home";
	}
	
	
/*
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDao loginDao){
		Authentication authentication =authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDao.getEmail(), 
														loginDao.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return ResponseEntity.ok("login Successfull");
	}
	
	
	*/
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "Register";
	}
	
	@PostMapping("/register")
	public String registerPost(@ModelAttribute("user") RegisterDao registerDao,Model model) {
		model.addAttribute("user", registerDao);
		this.userService.CreateUser(registerDao);
		return "logins";
	}
	/*
	
	@GetMapping("/ride")
	public String ride(Model model) {
		model.addAttribute("ride", new Ride());
		return "rideinformation";
	}
	
	@PostMapping("/ride")
	public String riderPost(@ModelAttribute("ride") RideDao rideDao,Model model) {
		model.addAttribute("ride", rideDao);
		this.rideService.CreateRide(rideDao);
		return "userinformation";
	}	
	

@GetMapping("/usershow")
public ModelAndView usershow() {
	ModelAndView mav=new ModelAndView("userinformation");
	mav.addObject("ride", this.userrepository.findAll());
	return mav;
	
}
	*/



	@GetMapping("/show")
	public ModelAndView show() {
		ModelAndView mav=new ModelAndView("cars");
		mav.addObject("products", this.productRepsitory.findAll());
		return mav;
		
	}
	
}
