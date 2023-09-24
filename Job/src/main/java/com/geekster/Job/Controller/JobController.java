package com.geekster.Job.Controller;

import com.geekster.Job.Model.Job;
import com.geekster.Job.Model.Type;
import com.geekster.Job.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    JobService jobService;


    // for one job details add
    /*
    @PostMapping("job")
    public String addJobDetails(@RequestBody Job newJob){
        return jobService.addJobDetails(newJob);
    }*/

    // for more job details add
    @PostMapping("job")
    public String addJobDetails(@RequestBody List<Job> newJob){
        return jobService.addJobDetails(newJob);
    }

    // for get all job details
    @GetMapping("job")
    public List<Job> getAllJobDetails(){
        return jobService.getAllJobDetails();
    }

    @DeleteMapping("job/id/{id}")
    public String removeJobById(@PathVariable Long id){
        return jobService.removeJobById(id);
    }

    @PutMapping("job/id/location")
    public String updateJobById(@RequestParam Long id,@RequestParam String location){
        return jobService.updateJobById(id,location);
    }

    @GetMapping("jobs/company/name/{companyName}")
    public List<Job> getAllJobsWithSameCompanyName(@PathVariable String companyName){
        return jobService.getAllJobsWithSameCompanyName(companyName);
    }

    @PutMapping("job/salary/{hike}/type/{type}")
    public String updateSalaryByType(@PathVariable float hike,@PathVariable Type type){
        return jobService.updateSalaryByType(hike,type);
    }

    @GetMapping("job/type/{type}/salary/lessOrEqual/{salary}")
    public List<Job> getJobsByTypeLessOrEqualSalary(@PathVariable Type type,@PathVariable double salary){
        return jobService.getJobsByTypeLessOrEqualSalary(type,salary);
    }

    @DeleteMapping("job/delete/description")
    public String deleteJobByDescription(@RequestBody String description){
        return jobService.deleteJobByDescription(description);
    }



}
