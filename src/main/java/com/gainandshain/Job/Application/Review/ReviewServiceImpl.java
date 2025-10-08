package com.gainandshain.Job.Application.Review;

import com.gainandshain.Job.Application.Company.Company;
import com.gainandshain.Job.Application.Company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ReviewServiceImpl implements  ReviewService{

    @Autowired
    CompanyService companyService;

    @Autowired
    ReviewRespository reviewRespository;

    @Override
    public ResponseEntity<String> addReview(long companyId, Review review) {

        Company company = companyService.getCompanyById(companyId).getBody();

        if(company!=null){
            review.setCompany(company);
            reviewRespository.save(review);
            return new ResponseEntity<>("Review added", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Not founded", HttpStatus.NOT_FOUND);
        }
    }
}
