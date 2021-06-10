package com.example.stockmarketapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockmarketapp.Exception.EmailExistsException;
import com.example.stockmarketapp.model.AuthenticationRequest;
import com.example.stockmarketapp.model.AuthenticationResponse;
import com.example.stockmarketapp.model.User;
import com.example.stockmarketapp.service.CustomUserDetailsService;
//import com.example.stockmarketapp.service.CustomUserDetailsService;
import com.example.stockmarketapp.service.UserService;
import com.example.stockmarketapp.service.UserServiceImpl;
import com.example.stockmarketapp.util.JwtUtil;

@RestController
public class UserController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		final User user = userService.findUserByUserName(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.status(HttpStatus.OK).body(new AuthenticationResponse(jwt, user));
	}

    @GetMapping("/users")
    public List<User> getAllUsers() {
    	return userService.getAllUsers();
    }
	
    @RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> registerUserAccount (@RequestBody User user, HttpServletRequest request
//	  Errors errors
	  ) throws EmailExistsException, Exception {
	    
//    	if(user.getUserType() == null) {
//    		user.setUserType();
//    	}
    	
    	try {
	        userService.saveUser(user);
	    } catch (EmailExistsException eeEx) {
	    	ResponseEntity.badRequest().body("Email Aready Exists");
	    } catch (Exception e) {
	    	ResponseEntity.badRequest().body(e);
	    }
	    

	    return ResponseEntity.ok(user);
	}
	
	@PostMapping("/updatepassword")
	public ResponseEntity<?> updatePassword (@RequestBody String password, HttpServletRequest request
	  ) throws UsernameNotFoundException{
		System.out.println(password);
		  final String authorizationHeader = request.getHeader("Authorization");

	        String username = null;
	        String jwt = null;

	        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
	            jwt = authorizationHeader.substring(7);
	            username = jwtTokenUtil.extractUsername(jwt);
	        }
	        
	        try{
	        	User user = userService.findUserByUserName(username);
	        	userService.updatePassword(password, user);
	        }catch(UsernameNotFoundException e) {
//	        	return ResponseEntity.badRequest();
	        }

	    return ResponseEntity.ok("password updated");
	}
//	
	
}

/*
User TODO:
-register
-login
-logout
-email confirmation
-update profile/ password
*/