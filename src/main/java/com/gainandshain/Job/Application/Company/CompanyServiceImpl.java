package com.gainandshain.Job.Application.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public ResponseEntity<List<Company>> getAllCompanies() {

        if(companyRepository.count()==0){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }else{

            List<Company> companies = companyRepository.findAll();
            return new ResponseEntity<>(companies,HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<Company> getCompanyById(long companyId) {

        Optional<Company> company = companyRepository.findById(companyId);

        if(company.isPresent()){
            return new ResponseEntity<>(company.get(),HttpStatus.OK);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<String> addCompany(Company company) {
        companyRepository.save(company);
        return new ResponseEntity<>("Company Added successfully !!",HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateCompanyById(long companyId,Company company) {

        Optional<Company> isFound = companyRepository.findById(companyId);

        if(isFound.isPresent()) {
            Company companyInfo = isFound.get();

            companyInfo.setCompanyName(company.getCompanyName());
            companyInfo.setCompanyName(company.getCompanyName());
            companyInfo.setCompanyDescription(company.getCompanyDescription());

            companyRepository.save(companyInfo);

            return new ResponseEntity<>("Company Details updated !!",HttpStatus.OK);

        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> deleteCompanyById(long companyId) {

        Optional<Company> isFound = companyRepository.findById(companyId);

        if(isFound.isPresent()){
            Company company = isFound.get();
            companyRepository.delete(company);
            return new ResponseEntity<>("Company Deleted !!",HttpStatus.OK);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
