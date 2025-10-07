package com.gainandshain.Job.Application.Job;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobService {

    ResponseEntity<List<Job>> fetchAllJobs();

    ResponseEntity<String> createNewJob(Job job);

    ResponseEntity<Job> fetchJobById(String jobId);

    ResponseEntity<String> deleteJobById(String jobId);

    ResponseEntity<String> updateJobById(String jobId,Job job);
}
