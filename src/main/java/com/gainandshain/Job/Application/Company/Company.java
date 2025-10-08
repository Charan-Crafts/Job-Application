package com.gainandshain.Job.Application.Company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gainandshain.Job.Application.Job.Job;
import com.gainandshain.Job.Application.Review.Review;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    public Company(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long companyId;

    private String companyName;

    private String companyDescription;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    @OneToMany(mappedBy = "company")
    private List<Review> review;

    public Company(long companyId, String companyName, String companyDescription, List<Job> jobs) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyDescription = companyDescription;
        this.jobs = jobs;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
