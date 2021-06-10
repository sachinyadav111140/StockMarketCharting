package com.StockMarketCharting.ImportData.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.StockMarketCharting.ImportData.model.Company;
import com.StockMarketCharting.ImportData.model.ExcelData;
import com.StockMarketCharting.ImportData.model.StockPrice;
import com.StockMarketCharting.ImportData.dao.companyDao;
import com.StockMarketCharting.ImportData.dao.stockExchangeDao;
import com.StockMarketCharting.ImportData.dao.stockPriceDao;

@RestController
public class ImportDataController {
	
	@Autowired
	companyDao companyDao;
	
	@Autowired
	stockExchangeDao stockExchangeDao;
	
	@Autowired
	stockPriceDao stockPriceDao;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@PostMapping("/")
	ResponseEntity<List<Boolean>> ImportData(@Validated @RequestBody ExcelData[] excelData) throws Exception {
        List<Boolean> responseList = new ArrayList<>();
		for(ExcelData e: excelData){
        	try{
        		modelMapper.typeMap(ExcelData.class,StockPrice.class)
        		.addMappings(mapper -> {
        			mapper.map(src -> companyDao.getByStockCode(src.getCompanyCode()).orElseThrow(), StockPrice::setCompany);
        			mapper.map(src -> stockExchangeDao.getByStockExchangeName(src.getStockExchange()).orElseThrow(), StockPrice::setStockExchange);
        			mapper.map(src -> src.getPricePerShare(), StockPrice::setCurrentPrice);
        				});
        		StockPrice stockPrice = modelMapper.map(e,StockPrice.class);
            	stockPriceDao.save(stockPrice);
//        		System.out.println(stockPrice.toString());
        		responseList.add(true);
        	}catch (Exception ex) {
//        		ex.printStackTrace();
        		responseList.add(false);
        		}
        	System.out.println(responseList);
        }
        return ResponseEntity.ok(responseList);
    }
	
	
}
