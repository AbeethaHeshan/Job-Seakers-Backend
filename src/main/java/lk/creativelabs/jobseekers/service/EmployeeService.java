package lk.creativelabs.jobseekers.service;
import lk.creativelabs.jobseekers.dto.EmployeeDTO;
import lk.creativelabs.jobseekers.dto.UserCredentialsDTO;

import java.util.ArrayList;

public interface EmployeeService {

    EmployeeDTO createNewEmployee(EmployeeDTO employeeDetails);
    boolean updateEmployee(EmployeeDTO employeeDetails);
    boolean deleteEmployee(String employeeId);
    String Login(UserCredentialsDTO loginDetails);
    ArrayList<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployee(String employeeId);






}
