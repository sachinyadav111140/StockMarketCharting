package com.StockMarketCharting.ImportData.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IPO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne
	private Company company;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable
	private List<StockExchange> stockExchanges = new ArrayList<>();
	
	@OneToOne
	private StockPrice pricePerShare;
	
	private Integer totalNumberOfShare;
	
	private LocalDateTime openDateTime;
	private String remarks;
}

/* 2. Company Name
3. Stock Exchange
4. Price per share
5. Total number of Shares
6. Open Date Time
7. Remarks*/
 