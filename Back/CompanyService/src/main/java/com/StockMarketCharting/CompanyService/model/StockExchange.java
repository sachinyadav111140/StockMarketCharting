package com.StockMarketCharting.CompanyService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockExchange {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String stockExchangeName;
	
	private String brief;
	private String contactAddress;
	private String remarks;
	
}
//
//1. Id
//2. Stock Exchange
//3. Brief
//4. Contact Address
//5. Remarks