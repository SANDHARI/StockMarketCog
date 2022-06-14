package com.stock.market.company.repository;

import com.stock.market.company.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Optional<Company> findByCode(String companyCode);

    void deleteByCode(String companyCode);
}
