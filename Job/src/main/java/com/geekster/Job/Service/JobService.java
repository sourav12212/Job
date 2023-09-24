package com.geekster.Job.Service;

import com.geekster.Job.Model.Job;
import com.geekster.Job.Model.Type;
import com.geekster.Job.Repository.IJobRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    IJobRepo jobRepo;


    /*
    public String addJobDetails(Job newJob) {
        jobRepo.save(newJob);
        return "Job added";
    }
    */
    public String addJobDetails(List<Job> newJob) {
        jobRepo.saveAll(newJob);
        return "Job added";
    }

    public List<Job> getAllJobDetails() {
        return (List<Job>) jobRepo.findAll();
    }

    public String removeJobById(Long id) {
        jobRepo.deleteById(id);
        return "deleted";
    }

    public String updateJobById(Long id, String location) {
        Job presentLocation = jobRepo.findById(id).orElse(null);
        if(presentLocation != null){
            presentLocation.setJobLocation(location);
            jobRepo.save(presentLocation);
            return "uodated";
        }else {
            return "id not found";
        }
    }

//    public List<Job> getAllJobsWithSameLocation(String location) {
//        return jobRepo.findByByLocation(location);
//    }

    public List<Job> getAllJobsWithSameCompanyName(String companyName) {
        return jobRepo.findByCompanyName(companyName);
    }

    @Transactional
    public String updateSalaryByType(float hike, Type type) {
        jobRepo.updateSalaryByType(hike,type.name());
        return "updated";
    }

    public List<Job> getJobsByTypeLessOrEqualSalary(Type type, double salary) {
        return jobRepo.findByJobTypeAndSalaryLessThanEqual(type,salary);
    }


    @Transactional
    public String deleteJobByDescription(String description) {
        jobRepo.deleteByDescription(description);
        return "deleted";
    }
}
