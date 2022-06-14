package com.stock.market.company.controller;

import com.stock.market.company.domain.Company;
import com.stock.market.company.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1.0/market")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/company/register")
    public ResponseEntity<?> registerCompany(@RequestBody Company company, HttpServletRequest request) {
        companyService.registerCompany(company);
        return new ResponseEntity<>("Company registered successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/company/info/{companyCode}")
    public ResponseEntity<?> getCompanyDetailsByCode(@PathVariable("companyCode") String companyCode,
                                                     HttpServletRequest request) {
       return ResponseEntity.of(companyService.getCompanyDetails(companyCode));
    }

    @GetMapping("/company/getall")
    public ResponseEntity<?> getCompanies(HttpServletRequest request) {
        return ResponseEntity.ok(companyService.getAllCompanyDetails());
    }

    @DeleteMapping("/company/delete/{companyCode}")
    public ResponseEntity<?> deleteCompanyByCode(@PathVariable("companyCode") String companyCode,
                                                 HttpServletRequest request) {
        companyService.deleteCompanyByCode(companyCode);
        return ResponseEntity.ok("Deleted company successfully!");
    }

}
