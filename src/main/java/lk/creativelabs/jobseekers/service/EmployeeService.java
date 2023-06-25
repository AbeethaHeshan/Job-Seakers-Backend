package lk.creativelabs.jobseekers.service;
import lk.creativelabs.jobseekers.dto.EmployeeDTO;
import lk.creativelabs.jobseekers.dto.UserCredentialsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeService {

    EmployeeDTO createNewEmployee(EmployeeDTO employeeDetails);
    EmployeeDTO updateEmployee(EmployeeDTO employeeDetails,String userId) throws Exception;
    boolean deleteEmployee(String employeeId);
    String Login(UserCredentialsDTO loginDetails);
    ArrayList<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployee(String userId,String role) throws Exception;


}
