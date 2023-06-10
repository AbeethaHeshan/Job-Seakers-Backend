package lk.creativelabs.jobseekers.repo;

import lk.creativelabs.jobseekers.entity.Client;
import lk.creativelabs.jobseekers.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,String> {
    // get employee details if username and password is success
    // get all employee
    // get employee by id
    // create employee
    // update employee
    // delete employee

      Employee getEmployeeByUserIdAndRole(String userId,String role);

      Optional<Employee> getEmployeeByUserId(String userId);

}
