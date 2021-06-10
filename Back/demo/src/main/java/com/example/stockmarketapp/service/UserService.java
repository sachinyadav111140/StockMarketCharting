package com.example.stockmarketapp.service;
import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.stockmarketapp.Exception.EmailExistsException;
import com.example.stockmarketapp.Exception.UsernameExistsException;
import com.example.stockmarketapp.model.User;

public interface UserService{
	
    User findUserByEmail(String email);
    User findUserByUserName(String username) throws UsernameNotFoundException;
    void saveUser(User user) throws EmailExistsException, UsernameExistsException;
//    Boolean removeAll();

//    void removeById(Long id);

    User findById(Long id);

    public void updatePassword(String newPassword, User user);
    
//    Page<User> searchByTerm(String name, Pageable pageable);
//
//    Page<User> listUsers(Pageable pageable);
//
    List<User> getAllUsers();
    
    
}
