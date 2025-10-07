package com.gainandshain.Job.Application.Job;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService{

    List<Job> allJobs = new ArrayList<>();
    @Override
    public ResponseEntity<List<Job>> fetchAllJobs() {

        if(allJobs.isEmpty()){
            throw new  ResponseStatusException(HttpStatus.NO_CONTENT,"Jobs are Empty");
        }else{
            return new ResponseEntity<>(allJobs,HttpStatus.OK) ;
        }
    }

    @Override
    public ResponseEntity<String> createNewJob(Job job) {
        //
        allJobs.add(job);

        return new ResponseEntity<>("Job Added", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Job> fetchJobById(String jobId) {
        // Check wheather the job is-exists or not

        Optional<Job> isJobFound = allJobs.stream()
                .filter(j->j.getJobId().equalsIgnoreCase(jobId))
                .findFirst();

        if(isJobFound.isPresent()){

            // Job is founded in the List

            return new ResponseEntity<>(isJobFound.get(),HttpStatus.FOUND);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Job not founded");
        }
    }


    @Override
    public ResponseEntity<String> deleteJobById(String jobId) {

        // Check wheather the job is-exists or not

        Optional<Job> isJobFounded = allJobs.stream()
                .filter(j->j.getJobId().equalsIgnoreCase(jobId))
                .findFirst();

        if(isJobFounded.isPresent()){

            allJobs.remove(isJobFounded.get());

            return new ResponseEntity<>("Job is deleted",HttpStatus.OK);

        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Job not found");
        }
    }

    @Override
    public ResponseEntity<String> updateJobById(String jobId, Job job) {


        Optional<Job> isJobFounded = allJobs.stream()
                .filter(j->j.getJobId().equalsIgnoreCase(jobId))
                .findFirst();

        if(isJobFounded.isPresent()){

            Job newJob = isJobFounded.get();
            newJob.setJobTitle(job.getJobTitle());
            newJob.setJobDescription(job.getJobDescription());
            newJob.setMinSalary(job.getMinSalary());
            newJob.setMaxSalary(job.getMaxSalary());
            newJob.setLocation(job.getLocation());

            allJobs.add(newJob);

            return new ResponseEntity<>("Job is updated",HttpStatus.OK);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
