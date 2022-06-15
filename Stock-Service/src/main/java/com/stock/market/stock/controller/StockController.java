package com.stock.market.stock.controller;


import com.stock.market.stock.model.StockPriceDTO;
import com.stock.market.stock.repository.StockPriceRepository;
import com.stock.market.stock.service.StockPriceService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1.0/market")
public class StockController {

    private final StockPriceService stockPriceService;
    
    @Autowired
    private StockPriceRepository stockPriceRepository;
  

    public StockController(StockPriceService stockPriceService) {
        this.stockPriceService = stockPriceService;
    }

    @PostMapping("/stock/add/{companyCode}")
    public ResponseEntity<?> addStockPrice(@PathVariable("companyCode") String companyCode,
                                           @RequestBody StockPriceDTO stockPriceDTO,
                                           HttpServletRequest request) {
        stockPriceService.addStockPrice(companyCode, stockPriceDTO);
        return new ResponseEntity<>("Stock price added successfully", HttpStatus.CREATED);
    }
    
    
    @GetMapping("/stock/get/{companyCode}/{startDate}/{endDate}")
    public ResponseEntity<?> fetchStockPrice(@PathVariable("companyCode") String companyCode,
                                           @PathVariable("startDate") String startDate,
                                           @PathVariable("endDate") String endDate,
                                           HttpServletRequest request) {
        return new ResponseEntity<>(stockPriceService.getStockPriceDetails(companyCode, startDate, endDate), HttpStatus.OK);
    }
    
    @GetMapping("/stock/get/{companyCode}")
    public ResponseEntity<?> getStockPrice(@PathVariable("companyCode") String companyCode,
                                           HttpServletRequest request) {
        return new ResponseEntity<>(stockPriceRepository.findByCompanyCode(companyCode), HttpStatus.OK);
    }
    
    @GetMapping("/stock/getall")
    public ResponseEntity<?> getStocks(HttpServletRequest request) {
        return new ResponseEntity<>(stockPriceService.getStockPriceDetails(), HttpStatus.OK);
    }
    
   
    

    
}
