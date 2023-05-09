package lk.creativelabs.jobseekers.service;
import lk.creativelabs.jobseekers.dto.EmployeeDTO;

import java.util.ArrayList;

public interface EmployeeService {

    EmployeeDTO createNewEmployee(EmployeeDTO employeeDetails);
    boolean updateEmployee(EmployeeDTO employeeDetails);
    boolean deleteEmployee(String employeeId);
    String Login(LoginDTO loginDetails);
    ArrayList<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployee(String employeeId);






}
