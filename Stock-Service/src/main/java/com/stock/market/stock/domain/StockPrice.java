package com.stock.market.stock.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;

//@Getter
//@Setter
@Document(collection = "stockPrice")
public class StockPrice {

    @Id
    private String id;

    private double stockPrice;

    private String companyCode;
  
    private LocalDateTime createdDate = LocalDateTime.now(ZoneId.systemDefault());

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	
 
}
