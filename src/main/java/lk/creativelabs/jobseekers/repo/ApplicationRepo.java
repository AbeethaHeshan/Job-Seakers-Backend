package lk.creativelabs.jobseekers.repo;

import lk.creativelabs.jobseekers.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepo extends JpaRepository<Application,String> {
       // get applications
       // get application by job id
       // get application by client id
       // get application by employee Id
       // create application

}
