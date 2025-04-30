package com.shivam._0.SpringBootREST;

import com.shivam._0.SpringBootREST.model.JobPost;
import com.shivam._0.SpringBootREST.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @Controller
@RestController // Allows spring to treat every controller in this class as returning data not view
@CrossOrigin(origins = "http://localhost:3000") // Allow these origins to hit the backend
public class JobRESTController {

    @Autowired
   private  JobService service;

    @GetMapping("jobPosts")
    // @ResponseBody // This tells spring that we are sending response data not a view (if you are not using @RestController
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}") // The curly brackets make it dynamic and @PathVariable helps us access
    public JobPost getPostById(@PathVariable("postId") int postId){

        return service.getJobById(postId);
    }

    // Sending data to server
    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost post){
        service.addJob(post);
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost job){
        service.updateJob(job);
        return service.getJobById(job.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId){
        service.deleteJob(postId);
        return "Post deleted successfully";
    }

    @GetMapping("load")
    public String loadData(){
        service.load();
        return "success";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }
}
