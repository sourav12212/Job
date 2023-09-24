package com.geekster.Job.Repository;

import com.geekster.Job.Model.Job;
import com.geekster.Job.Model.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobRepo extends CrudRepository<Job,Long> {


    //List<Job> findByJobsWithSameLocation(String location);

    //List<Job> findByJobsByLocation(String location);

    //List<Job> findByByLocation(String location);

    List<Job> findByCompanyName(String companyName);


    List<Job> findByJobTypeAndSalaryLessThanEqual(Type type, double salary);

    @Modifying
    @Query(value = "UPDATE JOB SET SALARY = (SALARY + SALARY *(:hike)) WHERE JOB_TYPE = :name",nativeQuery = true)
    void updateSalaryByType(float hike, String name);

    @Modifying
    @Query(value = "DELETE JOB WHERE DESCRIPTION = :description",nativeQuery = true)
    void deleteByDescription(String description);
}
