package lk.creativelabs.jobseekers.repo;

import lk.creativelabs.jobseekers.entity.Employee;
import lk.creativelabs.jobseekers.entity.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobCategoryRepo extends JpaRepository<JobCategory,String> {
             // get All data from  catogaries

            @Query("SELECT DISTINCT gc.jobType FROM JobCategory gc")
            List<String> findAllJobTypes();

            @Query("SELECT DISTINCT gc.serviceType FROM JobCategory gc")
            List<String> findAllServiceTypes();
}
