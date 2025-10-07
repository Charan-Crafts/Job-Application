package com.gainandshain.Job.Application.Job;

public class Job {

    private String jobTitle;

    private String jobId;

    private String companyName;

    private double minSalary;

    private double maxSalary;

    private String jobDescription;

    private String location;

    public Job(String jobTitle, String jobId, String companyName, double minSalary, double maxSalary, String jobDescription, String location) {
        this.jobTitle = jobTitle;
        this.jobId = jobId;
        this.companyName = companyName;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.jobDescription = jobDescription;
        this.location = location;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
