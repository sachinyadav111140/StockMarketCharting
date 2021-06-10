package com.StockMarketCharting.ImportData.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.StockMarketCharting.ImportData.model.StockExchange;

@Repository
public interface stockExchangeDao extends JpaRepository<StockExchange, Long>{
//	@Query
	public Optional<StockExchange> getByStockExchangeName(String stockExchangeName);
}
