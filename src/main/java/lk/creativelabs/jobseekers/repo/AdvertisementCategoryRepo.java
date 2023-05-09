package lk.creativelabs.jobseekers.repo;

import lk.creativelabs.jobseekers.entity.AdvertisementCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementCategoryRepo extends JpaRepository<AdvertisementCategory,String> {
             // get All data from  catogaries

}
