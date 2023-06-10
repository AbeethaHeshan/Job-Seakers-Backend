package lk.creativelabs.jobseekers.repo;

import lk.creativelabs.jobseekers.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepo extends JpaRepository<Advertisement,String> {
        // create advertiesment
        // update advertiesment
        // delete advertiesment

        // get all  adevrtiesments by catogary ID
        // get all  advertiesment
        // get all advertiesment by client id
}
