package lk.creativelabs.jobseekers.service.impl;

import lk.creativelabs.jobseekers.dto.ApplicationDTO;
import lk.creativelabs.jobseekers.dto.ApprovalDTO;
import lk.creativelabs.jobseekers.service.ApplicationService;

import java.util.ArrayList;

public class ApplicationStatusImpl implements ApplicationService {

    @Override
    public boolean createNewApplication() {
        return false;
    }

    @Override
    public ArrayList<ApplicationDTO> getAllOfEachClient(String clientId) {
        return null;
    }

    @Override
    public ApprovalDTO updateApprovalStatus(String status) {
        return null;
    }

    @Override
    public ApprovalDTO getApprovalStatusOfEmployee(String employeeId) {
        return null;
    }

    @Override
    public ArrayList<ApprovalDTO> getAllApprovalsOfEachEmployee(String employeeId) {
        return null;
    }
}
