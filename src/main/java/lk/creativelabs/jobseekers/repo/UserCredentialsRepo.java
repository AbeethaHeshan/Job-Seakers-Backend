package lk.creativelabs.jobseekers.repo;

import lk.creativelabs.jobseekers.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialsRepo extends JpaRepository<UserCredentials,String> {
         UserCredentials  findAllByUsernameAndPassword(String userName,String password);

          UserCredentials findByUsername(String username);

          UserCredentials findByUserId(String userId);
}
