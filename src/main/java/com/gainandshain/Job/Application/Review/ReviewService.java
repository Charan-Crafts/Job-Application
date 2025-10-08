package com.gainandshain.Job.Application.Review;


import org.springframework.http.ResponseEntity;

import java.util.*;
public interface ReviewService {

    ResponseEntity<List<Review>> getReviews(long companyId);

}
