package com.gainandshain.Job.Application.Job;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

public class JobController {

    List<Job> jobs = new ArrayList<>();

    // Get all jobs
    @GetMapping("/jobs")
    public List<Job> getAllJobs(){

        return jobs;
    }

    // Get specific job by Id
    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable String id){
        Job getJob =null;
        Optional<Job> isJobExists = jobs.stream()
                .filter(j->j.getJobId().equalsIgnoreCase(id)).findFirst();

        if(isJobExists.isPresent()){
            getJob = isJobExists.get();
            return getJob;
        }else{
            return getJob;
        }
    }


    // Add new Job
    @PostMapping("/addJob")
    public String createNewJob(@RequestBody Job newJob){
        jobs.add(newJob);

        return "New job added successfully !!";
    }


    // Delete the Job with Id
    @DeleteMapping("/deleteJob/{id}")
    public String deleteJobById(@PathVariable String id){

        Optional<Job> isExists = jobs.stream().
                filter(j->j.getJobId().equalsIgnoreCase(id))
                .findFirst();

        if(isExists.isPresent()){

            Job deletedJob = isExists.get();

            jobs.remove(deletedJob);

            return ("Job is deleted Successfully !");
        }else{
            return ("Job is not founded with id "+id);
        }
    }

    // Update specific job with id
    @PutMapping("/updateJob/{id}")
    public String updateJob(@PathVariable String id,@RequestBody Job job){

        Optional<Job> isJobExists = jobs.stream()
                .filter(j->j.getJobId().equalsIgnoreCase(id))
                .findFirst();

        if(isJobExists.isPresent()){

            Job newUpdateJob = isJobExists.get();
            newUpdateJob.setJobDescription(job.getJobDescription());
            newUpdateJob.setJobTitle(job.getJobTitle());
            newUpdateJob.setCompanyName(job.getCompanyName());
            newUpdateJob.setLocation(job.getCompanyName());
            newUpdateJob.setMaxSalary(job.getMaxSalary());
            newUpdateJob.setMinSalary(job.getMinSalary());

            return "Job is updated";
        }else{
            return ("Job is not founded with Id "+id);
        }
    }

    @GetMapping("/job/{id}/{company}")
    public Job getCompanySpecificJob(@PathVariable String id ,String company ){

        // Check wheater the job exists with that id

        Job getJobDetails = null;

        Optional<Job> isJobExists = jobs.stream().
                filter(j->j.getJobId().equalsIgnoreCase(id))
                .findFirst();

        if(isJobExists.isPresent()){

            // Check the company Matches

            Job foundedJob = isJobExists.get();

            if(foundedJob.getCompanyName().equalsIgnoreCase(company)){

                return  foundedJob;
            }else {
                return getJobDetails;
            }

        }else{
            return getJobDetails;
        }
    }
}
