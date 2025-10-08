package com.gainandshain.Job.Application.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/companies")
public class CompanyController {

    @Autowired
    CompanyServiceImpl companyService;

    @GetMapping("/getAllCompanies")
    public ResponseEntity<List<Company>> getALlCompanies(){

        try{
            return companyService.getAllCompanies();
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(Collections.emptyList(),e.getStatusCode());
        }
    }

    @GetMapping("/getCompany/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable long companyId){

        try{

            return companyService.getCompanyById(companyId);

        }catch (ResponseStatusException e){

            return new ResponseEntity<>(e.getStatusCode());
        }
    }

    @PostMapping("/addCompany")
    public ResponseEntity<String > addCompany(@RequestBody Company company){

        return companyService.addCompany(company);
    }

    @PutMapping("/updateCompany/{companyId}")
    public ResponseEntity<String> updateCompany(@PathVariable long companyId,@RequestBody Company company){

        try{
            return companyService.updateCompanyById(companyId,company);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>("Company not founded",e.getStatusCode());
        }
    }

    @DeleteMapping("/deleteCompany/{companyId}")
    public ResponseEntity<String > deleteCompany(@PathVariable long companyId){

        try{

            return companyService.deleteCompanyById(companyId);

        }catch (ResponseStatusException e){
            return new ResponseEntity<>("Company Not founded !!",e.getStatusCode());
        }
    }
}
