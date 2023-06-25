package lk.creativelabs.jobseekers.repo;

import lk.creativelabs.jobseekers.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AdvertisementRepo extends JpaRepository<Advertisement,String> {
        // create advertiesment
        // update advertiesment
        // delete advertiesment

        // get all  adevrtiesments by catogary ID
        // get all  advertiesment
        // get all advertiesment by client id


        @Query("SELECT e FROM Advertisement  e WHERE e.client.clientId = :clientId")
        List<Advertisement>  getAdvertisementsByClient(long clientId);

        boolean deleteAllByEndDate(LocalDate localDate);
}
