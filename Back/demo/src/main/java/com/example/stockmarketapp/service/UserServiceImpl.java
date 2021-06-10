package com.example.stockmarketapp.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.stockmarketapp.Exception.EmailExistsException;
import com.example.stockmarketapp.dao.UserDao;

import com.example.stockmarketapp.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Autowired
	    private PasswordEncoder passwordEncoder;

//
//	
//	public UserServiceImpl(UserDao userDao) {
//		super();
//		this.userDao = userDao;
//	}
//	
	@Override
	public User findUserByEmail(String email) {
		return userDao.findByEmail(email);
	}

	 @Override
	    public void saveUser(User user) throws EmailExistsException{
    
		 if(userDao.findByEmail(user.getEmail()) != null)
			 throw new EmailExistsException();
		 else {
			String encodedPasword = passwordEncoder.encode(user.getPassword());
//			System.out.println(encodedPasword);
		    user.setPassword(encodedPasword);

		    userDao.save(user);
		 }
	 }

	 @Override
	 public void updatePassword(String newPassword, User user){
	 	String encodedPasword = passwordEncoder.encode(newPassword);
	    user.setPassword(encodedPasword);
	    userDao.save(user);
	 }
	 
	 
	@Override
	public User findById(Long id) {
		return userDao.getById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User findUserByUserName(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		return user;
	}


	
}

/*
User TODO:
-register
-login
-logout
-email confirmation
-update profile/ password
*/