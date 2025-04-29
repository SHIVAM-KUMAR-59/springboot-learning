package com.shivam._0.SpringBootREST.service;

import com.shivam._0.SpringBootREST.model.JobPost;
import com.shivam._0.SpringBootREST.repository.JobRepository;
import com.shivam._0.SpringBootREST.model.JobPost;
import com.shivam._0.SpringBootREST.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository repo;

    public void addJob(JobPost jobPost){
        repo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repo.getAllJobs();
    }

    public JobPost getJobById(int id){
        return repo.getJobById(id);
    }

    public JobPost updateJob(JobPost job){
        return  repo.updateJob(job);
    }

    public void deleteJob(int postId){
        repo.deleteJob(postId);
    }


}
