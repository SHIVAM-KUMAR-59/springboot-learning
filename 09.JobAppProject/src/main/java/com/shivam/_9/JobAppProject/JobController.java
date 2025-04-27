package com.shivam._9.JobAppProject;

import com.shivam._9.JobAppProject.model.JobPost;
import com.shivam._9.JobAppProject.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    // For / and /home hit the home page
    @GetMapping({"/", "/home"})
    public String home(){
        return "home";
    }

    @GetMapping("/addjob")
    public String addJob(){
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost) {
        service.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewAllJobs(Model model){

        List<JobPost> jobs = service.getAllJobs();
        model.addAttribute("jobPosts", jobs);

        return "viewalljobs";

    }
}
