package com.gainandshain.Job.Application.Review;

import com.gainandshain.Job.Application.Company.Company;
<<<<<<< HEAD
import com.gainandshain.Job.Application.Company.CompanyService;
=======
import com.gainandshain.Job.Application.Company.CompanyServiceImpl;
>>>>>>> 12f286e42983576418e5b09889f21ea0600d6e18
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
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
=======

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    CompanyServiceImpl companyService;

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public ResponseEntity<List<Review>> getReviews(long companyId) {

        List<Review> reviews = reviewRepository.findByCompanyCompanyId(companyId);

        return new ResponseEntity<>(reviews, HttpStatus.FOUND);
>>>>>>> 12f286e42983576418e5b09889f21ea0600d6e18
    }
}
