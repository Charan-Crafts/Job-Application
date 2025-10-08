package com.gainandshain.Job.Application.Review;


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

    @JsonIgnore
    @ManyToOne
    private Company company;

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
