package com.stock.market.stock.service;

import java.util.List;

import com.stock.market.stock.domain.StockPrice;
import com.stock.market.stock.model.StockPriceDTO;
import com.stock.market.stock.model.StockPriceResponseDTO;

public interface StockPriceService {

    void addStockPrice(String companyCode, StockPriceDTO stockPriceDTO);
    
    StockPriceResponseDTO getStockPriceDetails(String  companyCode, String startDate, String endDate);
    
    List<StockPrice> getStockPriceDetails();

    
}
