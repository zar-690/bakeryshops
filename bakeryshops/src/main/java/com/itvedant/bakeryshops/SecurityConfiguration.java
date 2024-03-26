package com.itvedant.bakeryshops;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.itvedant.bakeryshops.service.MyUserDeatilsService;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity(prePostEnabled=true,jsr250Enabled = true ,securedEnabled=true)
public class SecurityConfiguration {// this are userd for security perposs
	@Bean
	public SecurityFilterChain config(HttpSecurity http) throws Exception{
		
		http=http.csrf().disable();
		
		http
			.authorizeHttpRequests()
			.requestMatchers(HttpMethod.GET,"/products/**").permitAll()   //this query are open to all
			.requestMatchers(HttpMethod.POST,"/products/**").permitAll()    // ** is given to chose speficif project
			.requestMatchers(HttpMethod.POST,"/users/**").permitAll()
			.requestMatchers(HttpMethod.GET,"/").authenticated()
			.anyRequest().permitAll()  // for this user and password are required
			.and().formLogin(form->form
					.loginPage("/users/login")
					.usernameParameter("email")
					.passwordParameter("password")
					.defaultSuccessUrl("/index")
					.failureUrl("/login?loginErrors=true"))
			.httpBasic(withDefaults())
			.authenticationProvider(daoAuhAuthenticationProvider());
		
		
		return http.build();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() { // used to encode the password for confidesiality// mtlb database mai jo password store hoga vo increment form mai rahega
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService users() {
	
		UserDetails user=User.builder()
						.username("user")
						.password(passwordEncoder().encode("password"))
						.roles("USER")
						.build();
	
		UserDetails admin=User.builder()
				.username("admin")
				.password(passwordEncoder().encode("password"))
				.roles("ADMIN","USER")
				.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	@Autowired
	private MyUserDeatilsService  myUserDeatilsService;
	
	@Bean
	public DaoAuthenticationProvider daoAuhAuthenticationProvider() {
		DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
		provider.setUserDetailsService(myUserDeatilsService);
		provider.setPasswordEncoder(this.passwordEncoder());
		return provider;
	}
	
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
}
