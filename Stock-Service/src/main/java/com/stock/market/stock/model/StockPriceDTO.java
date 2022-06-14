 package com.stock.market.stock.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

//@Getter
//@Setter
public class StockPriceDTO {

    @DecimalMin(value = "0.0", inclusive = false, message = "Stock price must be greater than 0.0")
    private double stockPrice;
    

	public double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

    
    
}
