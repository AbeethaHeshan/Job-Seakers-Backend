package lk.creativelabs.jobseekers.repo;

import lk.creativelabs.jobseekers.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepo extends JpaRepository<Rating,String> {
     // create rate by using id
     // get rating by id

}
