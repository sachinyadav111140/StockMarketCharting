package com.StockMarketCharting.ImportData.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.StockMarketCharting.ImportData.model.Company;

@Repository
public interface companyDao extends JpaRepository<Company,Long>{

//	@Query()
	public Optional<Company> getByStockCode(String companyCode);
	
//	@Query
//	public Company findByEmail(String email);
	
}
