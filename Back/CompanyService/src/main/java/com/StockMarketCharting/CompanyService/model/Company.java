package com.StockMarketCharting.CompanyService.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String comapnyName;
	
	@ManyToOne
	private Sector sector;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "company_stockExchanges")
	private List<StockExchange> stockExhanges = new ArrayList<>();
	
	private String ceo;
	
	private Integer turnover;
	
	private String[] boardOfDirectors;
	
	private String details;
	
	@Column(nullable = false)
	private String stockCode;
	
}
/*
5. Listed in Stock Exchanges
6. Sector
8. Stock code in each Stock Exchange
*/
