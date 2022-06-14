package com.stock.market.stock.repository;

import com.stock.market.stock.domain.StockPrice;

import java.time.LocalDateTime;
import java.util.List;

import javax.swing.text.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockPriceRepository extends MongoRepository<StockPrice, String> {
	

	List<StockPrice> findByCompanyCode(String companyCode);

	List<StockPrice> findByCompanyCodeAndCreatedDateBetween(String companyCode, LocalDateTime startDate, LocalDateTime endDate);
	

	
}
