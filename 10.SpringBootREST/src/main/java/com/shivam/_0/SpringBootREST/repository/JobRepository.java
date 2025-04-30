package com.shivam._0.SpringBootREST.repository;

//import com.shivam._0.SpringBootREST.model.JobPost;
//import com.shivam._0.SpringBootREST.model.JobPost;
import com.shivam._0.SpringBootREST.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;

/*
@Repository
public class JobRepository {


    ArrayList to store JobPost objects
    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                    List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                    List.of("HTML", "CSS", "JavaScript", "React")),
            new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                    List.of("Python", "Machine Learning", "Data Analysis")),
            new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                    List.of("Networking", "Cisco", "Routing", "Switching")),
            new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                    List.of("iOS Development", "Android Development", "Mobile App"))
    ));


    // method to return all JobPosts
    public List<JobPost> getAllJobs() {
        return jobs;
    }

    // method to save a job post object into arrayList
    public void addJob(JobPost job) {
        jobs.add(job);
        System.out.println(jobs);
    }

    // method to get a job post by id
    public JobPost getJobById(int id){
        JobPost job = null;
        for(JobPost post : jobs){
            if(post.getPostId() == id){
                job = post;
                break;
            }
        }

        return job;
    }

    public JobPost updateJob(JobPost job){
        for(JobPost post : jobs){
            if(post.getPostId() == job.getPostId()){
                post.setPostProfile(job.getPostProfile());
                post.setPostDesc(job.getPostDesc());
                post.setReqExperience(job.getReqExperience());
                post.setPostTechStack(job.getPostTechStack());
            }
            return post;
        }
        return null;
    }

    public void deleteJob(int postId){
        for(JobPost post : jobs){
            if(post.getPostId() == postId){
                jobs.remove(post);
            }
        }
    }





}
*/

@Repository
public interface JobRepository extends JpaRepository<JobPost, Integer> {

    public List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);
}
