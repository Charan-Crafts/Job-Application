package com.gainandshain.Job.Application.Job;


import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
public class JobController{

    @Autowired
    JobServiceImpl jobService;

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> fetchAllJobs(){
        try {
            return jobService.fetchAllJobs();
        } catch (ResponseStatusException e) {
            return new ResponseEntity(Collections.emptyList(),e.getStatusCode());
        }
    }

    @PostMapping("/addJob")
    public ResponseEntity<String > addNewJob(@RequestBody Job job){

        return jobService.createNewJob(job);
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<Job> getSingleJob(@PathVariable String jobId){

        try{
            return jobService.fetchJobById(jobId);
        }catch (ResponseStatusException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteJob/{jobId}")
    public ResponseEntity<String> deleteJobById(@PathVariable String jobId){

        try{

            return jobService.deleteJobById(jobId);

        }catch (ResponseStatusException e){

            return new ResponseEntity<>("Job Not founded", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateJob/{jobId}")
    public ResponseEntity<String> updateJobById(@PathVariable String jobId,@RequestBody Job job){

        try{
            return jobService.updateJobById(jobId,job);
        }catch (ResponseStatusException e){

            return  new ResponseEntity<>("Job not found",e.getStatusCode());
        }
    }
}