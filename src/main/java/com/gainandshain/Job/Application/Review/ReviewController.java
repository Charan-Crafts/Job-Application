package com.gainandshain.Job.Application.Review;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/review/{companyId}")
public class ReviewController {

    @Autowired
    ReviewServiceImpl reviewService;

    @GetMapping("")
    public ResponseEntity<List<Review>> getReviews(long companyId){
        return reviewService.getReviews(companyId);
    }

}
