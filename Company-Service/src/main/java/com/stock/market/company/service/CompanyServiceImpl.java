package com.stock.market.company.service;

import com.stock.market.company.domain.Company;
import com.stock.market.company.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CompanyServiceImpl.class);

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void registerCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Optional<Company> getCompanyDetails(String companyCode) {
        return companyRepository.findByCode(companyCode);
    }

    @Override
    public List<Company> getAllCompanyDetails() {
        return companyRepository.findAll();
    }

    @Override
    public void deleteCompanyByCode(String companyCode) {
        companyRepository.findByCode(companyCode).ifPresent(c -> {
            companyRepository.deleteById(c.getId());
        });
    }

	@Override
	public void updateCompany(String companyCode) {
		
		Optional<Company> optional = companyRepository.findByCode(companyCode);
	}
    
    
}
