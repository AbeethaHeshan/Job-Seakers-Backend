package lk.creativelabs.jobseekers.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lk.creativelabs.jobseekers.entity.emberded.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)  // only get constructor values ,if contructor have not some variable not return null or variable
public class EmployeeDTO {

    private String name;
    private Address address;
    private LocalDate dateOfBirth;
    private String email;
    private String tel;
    private String profileImageUri;
    private String workingType;
    private String userName;
    private String password;
    private String jobType;
    private String userId;
    private String jobRoleType;  // waiter , cook , manager
    private String role; // admin , client , employee

    public EmployeeDTO(String name, Address address, LocalDate dateOfBirth, String email, String tel, String profileImageUri, String workingType, String userName, String password, String jobType) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.tel = tel;
        this.profileImageUri = profileImageUri;
        this.workingType = workingType;
        this.userName = userName;
        this.password = password;
        this.jobType = jobType;
    }

    public EmployeeDTO(String name, Address address, LocalDate dateOfBirth, String email, String tel, String profileImageUri, String workingType, String jobType ,String userId) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.tel = tel;
        this.profileImageUri = profileImageUri;
        this.workingType = workingType;
        this.jobType = jobType;
        this.userId = userId;
    }

    public EmployeeDTO(String name, Address address, LocalDate dateOfBirth, String email, String tel, String profileImageUri, String workingType, String jobType ) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.tel = tel;
        this.profileImageUri = profileImageUri;
        this.workingType = workingType;
        this.jobType = jobType;

    }


}
