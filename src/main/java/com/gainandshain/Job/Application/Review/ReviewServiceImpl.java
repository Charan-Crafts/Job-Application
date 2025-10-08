package com.gainandshain.Job.Application.Review;

import com.gainandshain.Job.Application.Company.Company;
import com.gainandshain.Job.Application.Company.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    }
}
