package com.gainandshain.Job.Application.Review;

<<<<<<< HEAD
public class ReviewController {
=======

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

>>>>>>> 12f286e42983576418e5b09889f21ea0600d6e18
}
