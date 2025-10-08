package com.gainandshain.Job.Application.Review;

<<<<<<< HEAD
=======

>>>>>>> 12f286e42983576418e5b09889f21ea0600d6e18
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gainandshain.Job.Application.Company.Company;
import jakarta.persistence.*;

@Entity
public class Review {


    public Review(){}

    public Review(long reviewId, String reviewTitle, String reviewDescription, Company company) {
        this.reviewId = reviewId;
        this.reviewTitle = reviewTitle;
        this.reviewDescription = reviewDescription;
        this.company = company;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewId;

    private String reviewTitle;

    private String reviewDescription;

<<<<<<< HEAD
    private double rating;

    @JsonIgnore
    @ManyToOne
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Review(){}

    public Review(long reviewId, String reviewTitle, String reviewDescription, double rating) {
        this.reviewId = reviewId;
        this.reviewTitle = reviewTitle;
        this.reviewDescription = reviewDescription;
        this.rating = rating;
    }
=======
    @JsonIgnore
    @ManyToOne
    private Company company;
>>>>>>> 12f286e42983576418e5b09889f21ea0600d6e18

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
