package com.gainandshain.Job.Application.Job;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    JobRepository jobRepository;


    @Override
    public ResponseEntity<List<Job>> fetchAllJobs() {

        if(jobRepository.count()==0){
            throw new  ResponseStatusException(HttpStatus.NO_CONTENT,"Jobs are Empty");
        }else{
            return new ResponseEntity<>(jobRepository.findAll(),HttpStatus.OK) ;
        }
    }

    @Override
    public ResponseEntity<String> createNewJob(Job job) {

        Job savedJob =jobRepository.save(job);

        String getJobId = String.format("JOB-%03d",savedJob.getId());

        savedJob.setJobId(getJobId);

        jobRepository.save(savedJob);

        return new ResponseEntity<>("Job Added", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Job> fetchJobById(String jobId) {
        // Check wheather the job is-exists or not

        List<Job> jobs = jobRepository.findAll();

        Optional<Job> isJob = jobs.stream()
                .filter(j->j.getJobId().equalsIgnoreCase(jobId)).findFirst();


        if(isJob.isPresent()){

            // Job is founded in the List

            return new ResponseEntity<>(isJob.get(),HttpStatus.FOUND);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Job not founded");
        }
    }


    @Override
    public ResponseEntity<String> deleteJobById(String jobId) {

        // Check wheather the job is-exists or not

        List<Job> jobs = jobRepository.findAll();

        Optional<Job> isJobFounded = jobs.stream()
                .filter(j->j.getJobId().equalsIgnoreCase(jobId)).findFirst();

        if(isJobFounded.isPresent()){

            jobRepository.delete(isJobFounded.get());

            return new ResponseEntity<>("Job is deleted",HttpStatus.OK);

        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Job not found");
        }
    }

    @Override
    public ResponseEntity<String> updateJobById(String jobId, Job job) {

        List<Job> jobs = jobRepository.findAll();


        Optional<Job> isJobFounded = jobs.stream()
                .filter(j->j.getJobId().equalsIgnoreCase(jobId))
                .findFirst();

        if(isJobFounded.isPresent()){

            Job newJob = isJobFounded.get();
            newJob.setJobTitle(job.getJobTitle());
            newJob.setJobDescription(job.getJobDescription());
            newJob.setMinSalary(job.getMinSalary());
            newJob.setMaxSalary(job.getMaxSalary());
            newJob.setLocation(job.getLocation());

            jobRepository.save(newJob);

            return new ResponseEntity<>("Job is updated",HttpStatus.OK);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
