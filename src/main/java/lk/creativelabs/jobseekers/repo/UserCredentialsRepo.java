package lk.creativelabs.jobseekers.repo;

import lk.creativelabs.jobseekers.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialsRepo extends JpaRepository<UserCredentials,String> {

}
