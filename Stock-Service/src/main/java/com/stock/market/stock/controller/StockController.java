package com.stock.market.stock.controller;

import com.stock.market.stock.domain.StockPrice;
import com.stock.market.stock.model.StockPriceDTO;
import com.stock.market.stock.repository.StockPriceRepository;
import com.stock.market.stock.service.StockPriceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1.0/market")
public class StockController {

    private final StockPriceService stockPriceService;
    
    @Autowired
    private StockPriceRepository stockPriceRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;

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
    
    
    @GetMapping("/stock/add/{companyCode}/{startDate}/{endDate}")
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
    
    @GetMapping("/stock/agg")
    public ResponseEntity<?> getStockAgg(HttpServletRequest request) {
        return new ResponseEntity<>(stockPriceService.getStockPriceDetailsAgg(), HttpStatus.OK);
    }
    

    
}
