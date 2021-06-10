package com.StockMarketCharting.ImportData.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StockMarketCharting.ImportData.model.StockPrice;

public interface stockPriceDao extends JpaRepository<StockPrice, Long> {
	
}
