package com.gainandshain.Job.Application.Company;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyService {

    public ResponseEntity<List<Company>> getAllCompanies();

    public ResponseEntity<Company> getCompanyById(long companyId);

    public ResponseEntity<String> addCompany(Company company);

    public ResponseEntity<String> updateCompanyById(long companyId, Company company);

    public ResponseEntity<String > deleteCompanyById(long companyId);
}
