package com.stock.market.stock.model;

import java.util.List;

import com.stock.market.stock.domain.StockPrice;

public class StockPriceResponseDTO {
	
	private List<StockPrice> stockPrices;
	
	private double average;
	
	private double minValue;
	
	private double maxValue;

	public List<StockPrice> getStockPrices() {
		return stockPrices;
	}

	public void setStockPrices(List<StockPrice> stockPrices) {
		this.stockPrices = stockPrices;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public double getMinValue() {
		return minValue;
	}

	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	public double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}
}
