package lk.creativelabs.jobseekers.service.impl;

import lk.creativelabs.jobseekers.dto.EmployeeDTO;
import lk.creativelabs.jobseekers.dto.UserCredentialsDTO;
import lk.creativelabs.jobseekers.entity.Employee;
import lk.creativelabs.jobseekers.entity.UserCredentials;
import lk.creativelabs.jobseekers.repo.EmployeeRepo;
import lk.creativelabs.jobseekers.repo.UserCredentialsRepo;
import lk.creativelabs.jobseekers.service.EmployeeService;
import lk.creativelabs.jobseekers.util.UserIdGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    UserCredentialsRepo authRepo;


    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDetails) {
        try{
            String userId = UserIdGenerator.generateUserId();
            Employee employee = mapper.map(employeeDetails, Employee.class);
            employee.setUserId(userId);
            employeeRepo.save(employee);
            authRepo.save(new UserCredentials(employeeDetails.getUserName(), passwordEncoder.encode(employeeDetails.getPassword()),userId,employeeDetails.getRole()));
           return new EmployeeDTO(employeeDetails.getName(),employeeDetails.getAddress(),employeeDetails.getDateOfBirth(),employeeDetails.getEmail(),employeeDetails.getTel(),employeeDetails.getProfileImageUri(),employeeDetails.getWorkingType(),employeeDetails.getJobType())  ;

        }catch (Error error){
          return null;
        }
    }

    @Override
    public boolean updateEmployee(EmployeeDTO employeeDetails) {
        return false;
    }

    @Override
    public boolean deleteEmployee(String employeeId) {
        return false;
    }

    @Override
    public String Login(UserCredentialsDTO loginDetails) {
        return null;
    }

    @Override
    public ArrayList<EmployeeDTO> getAllEmployees() {
        return null;
    }

    @Override
    public EmployeeDTO getEmployee(String userId,String role) throws Exception {
        try{
            Employee employee = employeeRepo.getEmployeeByUserIdAndRole(userId, role);
            EmployeeDTO employeeDTO =  new EmployeeDTO(employee.getName(),employee.getAddress(),employee.getDateOfBirth(),employee.getEmail(),employee.getTel(),employee.getProfileImageUri(),employee.getWorkingType(),employee.getJobType());
            return employeeDTO;
        }catch (Exception exception){
            throw new Exception(exception);
        }

    }
}
