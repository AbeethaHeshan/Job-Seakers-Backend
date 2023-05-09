package lk.creativelabs.jobseekers.repo;

import lk.creativelabs.jobseekers.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,String> {
     // get client details if username and password is success
     // get all client
     // get client by id
     // create client
     // update client
     // delete client


}
