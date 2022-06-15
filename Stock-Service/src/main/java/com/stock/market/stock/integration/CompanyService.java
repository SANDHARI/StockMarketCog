package com.stock.market.stock.integration;

import com.stock.market.stock.model.Company;

public interface CompanyService {
	
	Company getCompanyDetails(String companyCode);

}
