package lk.creativelabs.jobseekers.repo;

import lk.creativelabs.jobseekers.entity.Approval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalRepo extends JpaRepository<Approval,String> {
           // get approval details by application id
           // update approve status
           // get all approval details
}
