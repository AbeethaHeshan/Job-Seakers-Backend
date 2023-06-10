package lk.creativelabs.jobseekers.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lk.creativelabs.jobseekers.entity.emberded.Address;
import lk.creativelabs.jobseekers.entity.enums.ApprovalStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDTO {

    private String owner;
    private String businessName;
    private String businessType;
    private Address address;
    private String businessRegistrationDocUri;
    private String businessRegistrationNo;
    private String email;
    private String tel;
    private String profileImageUri;
    private String userName;
    private String password;
    private ApprovalStatus approvalStatus = ApprovalStatus.PENDING;
    private String role;


    public ClientDTO(String owner, String businessName, String businessType, Address address, String businessRegistrationDocUri, String businessRegistrationNo, String email, String tel, String profileImageUri, String userName, String password, ApprovalStatus approvalStatus) {
        this.owner = owner;
        this.businessName = businessName;
        this.businessType = businessType;
        this.address = address;
        this.businessRegistrationDocUri = businessRegistrationDocUri;
        this.businessRegistrationNo = businessRegistrationNo;
        this.email = email;
        this.tel = tel;
        this.profileImageUri = profileImageUri;
        this.userName = userName;
        this.password = password;
        this.approvalStatus = approvalStatus;
    }


    public ClientDTO(String owner, String businessName, String businessType, Address address, String email, String tel, String profileImageUri, ApprovalStatus approvalStatus) {
        this.owner = owner;
        this.businessName = businessName;
        this.businessType = businessType;
        this.address = address;
        this.email = email;
        this.tel = tel;
        this.profileImageUri = profileImageUri;
        this.approvalStatus = approvalStatus;

    }

    public ClientDTO(String owner, String businessName, String businessType, Address address, String businessRegistrationDocUri, String businessRegistrationNo, String email, String tel, String profileImageUri,ApprovalStatus approvalStatus) {
        this.owner = owner;
        this.businessName = businessName;
        this.businessType = businessType;
        this.address = address;
        this.businessRegistrationDocUri = businessRegistrationDocUri;
        this.businessRegistrationNo = businessRegistrationNo;
        this.email = email;
        this.tel = tel;
        this.profileImageUri = profileImageUri;
        this.approvalStatus = approvalStatus;
    }

    public ClientDTO(String owner, String businessName, String businessType, Address address, String email, String tel, String profileImageUri) {
        this.owner = owner;
        this.businessName = businessName;
        this.businessType = businessType;
        this.address = address;
        this.email = email;
        this.tel = tel;
        this.profileImageUri = profileImageUri;
    }

}
