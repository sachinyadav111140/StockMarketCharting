package com.example.stockmarketapp.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.stockmarketapp.model.User;

@Repository
public interface UserDao extends JpaRepository<User,Long>{

	@Query
	public User findByUsername(String username);
	
	@Query
	public User findByEmail(String email);
	
}
