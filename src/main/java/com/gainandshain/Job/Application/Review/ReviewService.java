package com.gainandshain.Job.Application.Review;

<<<<<<< HEAD
import org.springframework.http.ResponseEntity;

public interface ReviewService {

    ResponseEntity<String> addReview(long companyId,Review review);
=======

import org.springframework.http.ResponseEntity;

import java.util.*;
public interface ReviewService {

    ResponseEntity<List<Review>> getReviews(long companyId);

>>>>>>> 12f286e42983576418e5b09889f21ea0600d6e18
}
