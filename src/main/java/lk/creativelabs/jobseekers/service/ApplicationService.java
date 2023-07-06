package lk.creativelabs.jobseekers.service;

import lk.creativelabs.jobseekers.dto.ApplicationDTO;
import lk.creativelabs.jobseekers.dto.ApprovalDTO;

import java.util.ArrayList;

public interface ApplicationService {

    ApplicationDTO createNewApplication(String clientId,String employeeId, ApplicationDTO applicationDTO);

    ArrayList<ApplicationDTO> getAllOfEachClient(String clientId);
    ApprovalDTO updateApprovalStatus(String status);
    ApprovalDTO getApprovalStatusOfEmployee(String employeeId);
    ArrayList<ApprovalDTO> getAllApprovalsOfEachEmployee(String employeeId);
}
