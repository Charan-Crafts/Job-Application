package com.gainandshain.Job.Application.Review;

import org.springframework.http.ResponseEntity;

public interface ReviewService {

    ResponseEntity<String> addReview(long companyId,Review review);
}
