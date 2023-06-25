package lk.creativelabs.jobseekers.repo;

import lk.creativelabs.jobseekers.entity.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JobCategoryRepo extends JpaRepository<JobCategory,String> {
             // get All data from  catogaries

            @Query("SELECT DISTINCT gc.jobType FROM JobCategory gc")
            List<String> findAllJobTypes();

            @Query("SELECT DISTINCT gc.serviceType FROM JobCategory gc")
            List<String> findAllServiceTypes();


            @Query(value = "SELECT jc.serviceType FROM JobCategory jc WHERE jc.jobType = :category")
            List<String> findAllServiceTypesByJobType(String category);

            @Query("SELECT gc.categoryId FROM JobCategory gc WHERE gc.serviceType = :type")
            long findCategoryIdByJobType(String type);

            Optional<JobCategory> getJobCategoryByCategoryId(long id);

}
