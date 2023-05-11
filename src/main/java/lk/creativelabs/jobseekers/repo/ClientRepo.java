package lk.creativelabs.jobseekers.repo;

import lk.creativelabs.jobseekers.entity.Client;
import lk.creativelabs.jobseekers.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepo extends JpaRepository<Client,String> {
     // get client details if username and password is success
     // get all client
     // get client by id
     // create client
     // update client
     // delete client
     Client getClientByUserIdAndRole(String userId, String role);



       @Query("SELECT c.approvalStatus FROM Client  c WHERE c.userId = :userId")
       String findApprovalStatusByUserId(String userId);


}
