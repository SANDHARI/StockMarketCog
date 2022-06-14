package com.stock.market.stock.service;

import com.stock.market.stock.domain.StockPrice;
import com.stock.market.stock.model.StockPriceDTO;
import com.stock.market.stock.model.StockPriceResponseDTO;
import com.stock.market.stock.repository.StockPriceRepository;
import com.stock.market.stock.utils.DateUtils;

import java.util.List;


import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

@Service
public class StockPriceServiceImpl implements StockPriceService {

    private final static Logger LOGGER = LoggerFactory.getLogger(StockPriceServiceImpl.class);

    private final StockPriceRepository stockPriceRepository;

    public StockPriceServiceImpl(StockPriceRepository stockPriceRepository) {
        this.stockPriceRepository = stockPriceRepository;
    }
    
    @Autowired
    MongoTemplate mongoTemplate;

   
    @Override
    public void addStockPrice(String companyCode, StockPriceDTO stockPriceDTO) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.setStockPrice(stockPriceDTO.getStockPrice());
        stockPrice.setCompanyCode(companyCode);
        stockPriceRepository.save(stockPrice);
    }


	@Override
	public StockPriceResponseDTO getStockPriceDetails(String companyCode, String startDate, String endDate) {
		List<StockPrice> stockPrices = stockPriceRepository.findByCompanyCodeAndCreatedDateBetween(companyCode,
				DateUtils.convertStringToLocalDateTime(startDate), DateUtils.convertStringToLocalDateTime(endDate));
		StockPriceResponseDTO stockResponseDTO = new StockPriceResponseDTO();
		stockResponseDTO.setStockPrices(stockPrices);
		MatchOperation matchOpaOperation = Aggregation.match(Criteria.where("companyCode").is(companyCode).andOperator(
				Criteria.where("createdDate").gte(DateUtils.convertStringToLocalDateTime(startDate)),
				Criteria.where("createdDate").lt(DateUtils.convertStringToLocalDateTime(endDate))));
		Aggregation aggregation = Aggregation.newAggregation(matchOpaOperation, Aggregation.group().avg("$stockPrice")
				.as("avgPrice").max("$stockPrice").as("maxPrice").min("$stockPrice").as("minPrice"));
		AggregationResults<Document> document = mongoTemplate.aggregate(aggregation, "stockPrice", Document.class);
		if(document != null && document.getRawResults() != null && document.getRawResults().get("results") != null) {
			List<Document> results = (List<Document>)document.getRawResults().get("results");
			if(!results.isEmpty()) {
				stockResponseDTO.setAverage(results.get(0).get("avgPrice", Double.class));
				stockResponseDTO.setMaxValue(results.get(0).get("maxPrice", Double.class));
				stockResponseDTO.setMinValue(results.get(0).get("minPrice", Double.class));
			}
		}
		return stockResponseDTO;
	}

	@Override
	public List<StockPrice> getStockPriceDetails() {
		
		return stockPriceRepository.findAll();
	}

    
    
}
