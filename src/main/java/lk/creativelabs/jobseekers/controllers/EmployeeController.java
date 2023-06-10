package lk.creativelabs.jobseekers.controllers;

import lk.creativelabs.jobseekers.dto.ClientDTO;
import lk.creativelabs.jobseekers.dto.EmployeeDTO;
import lk.creativelabs.jobseekers.service.EmployeeService;
import lk.creativelabs.jobseekers.util.ResponseUtil;
import lk.creativelabs.jobseekers.util.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.sql.SQLException;

@RestController
@RequestMapping("employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService ;
    @PostMapping(value = "/createNew",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil createNewEmployee(@RequestBody EmployeeDTO employeeDTO,@RequestHeader(required = true) String role){

        if(role.equals(UserRole.EMPLOYEE.getAuthority())){
            employeeDTO.setRole(UserRole.EMPLOYEE.getAuthority());
            return new ResponseUtil(200,"save_success",employeeService.createNewEmployee(employeeDTO));
        }else{
            return new ResponseUtil(400,"user role is not valid",null);
        }
    }

    @PostMapping(value ="/getemployee" ,produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil getEmployeeDetails(@RequestHeader( required = true) String userId,
                                           @RequestHeader( required = true) String role) throws Exception {

        if (role.equals(UserRole.EMPLOYEE.getAuthority())) {
               return new ResponseUtil(200,"get_user_success",employeeService.getEmployee(userId,role));
        } else {
               return new ResponseUtil(400,"user role is not valid",null);
        }

    }

    @PostMapping(value = "/update" ,consumes = {MediaType.APPLICATION_JSON_VALUE} ,produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil updateEmployee(@RequestBody EmployeeDTO employeeDTO,@RequestHeader String userId) throws Exception {

        return new ResponseUtil(200,"employee update successfull", employeeService.updateEmployee(employeeDTO,userId));

    }

    @PostMapping(value = "/delete"  ,produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil deleteEmployee(@RequestHeader String userId){

        return null;
    }


    //send message to the client


}
