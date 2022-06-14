package com.stock.market.company.service;

import com.stock.market.company.domain.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    void registerCompany(Company company);
    void updateCompany(String companyCode);

    Optional<Company> getCompanyDetails(String companyCode);

    List<Company> getAllCompanyDetails();

    void deleteCompanyByCode(String companyCode);
}
