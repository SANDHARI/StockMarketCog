package com.stock.market.stock.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stock.market.stock.exception.IntegrationException;
import com.stock.market.stock.model.Company;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyServiceImpl.class);
	
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Company getCompanyDetails(String companyCode) {
		try {
			ResponseEntity<Company> companyResponse = restTemplate
					.getForEntity("http://COMPANY-SERVICE/api/v1.0/market/company/info/" + companyCode, Company.class);
			if (companyResponse.getStatusCode().is2xxSuccessful() && companyResponse.getBody() != null)
				return companyResponse.getBody();
			throw new IntegrationException(companyResponse.getStatusCode().getReasonPhrase(), "Company service returned error response", 
					companyResponse.getStatusCodeValue());
		} catch (Exception e) {
			throw new IntegrationException("Exception while accessing company service", e);
		}
	}


}
