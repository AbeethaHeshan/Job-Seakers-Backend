package lk.creativelabs.jobseekers.service.impl;

import lk.creativelabs.jobseekers.dto.ApplicationDTO;
import lk.creativelabs.jobseekers.dto.ApprovalDTO;
import lk.creativelabs.jobseekers.entity.Application;
import lk.creativelabs.jobseekers.entity.Approval;
import lk.creativelabs.jobseekers.entity.Client;
import lk.creativelabs.jobseekers.entity.Employee;
import lk.creativelabs.jobseekers.entity.enums.ApprovalStatus;
import lk.creativelabs.jobseekers.repo.ApplicationRepo;
import lk.creativelabs.jobseekers.repo.ClientRepo;
import lk.creativelabs.jobseekers.repo.EmployeeRepo;
import lk.creativelabs.jobseekers.service.ApplicationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Transactional
@Service
public class ApplicationStatusImpl implements ApplicationService {

    @Autowired
    ApplicationRepo applicationRepo;

    @Autowired
    ClientRepo clientRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    ModelMapper modalMapper;


    @Override
    public ApplicationDTO createNewApplication(String clientId,String employeeId, ApplicationDTO applicationDTO) {

        Optional<Client> client = clientRepo.getClientByUserId(clientId);
        Optional<Employee> employeeByUserId = employeeRepo.getEmployeeByUserId(employeeId);

        Application application = new Application();
        Approval approval = new Approval();

        application.setClient(client.get());
        application.setEmployee(employeeByUserId.get());
        application.setName(applicationDTO.getName());
        application.setAddress(applicationDTO.getAddress());
        application.setEmail(applicationDTO.getEmail());
        application.setCvUri(applicationDTO.getCvUri());
        application.setDateOfBirth(applicationDTO.getDateOfBirth());
        application.setJobCatogary(applicationDTO.getJobCatogary());
        application.setTelOne(applicationDTO.getTelOne());
        application.setUserId(applicationDTO.getUserId());
        application.setAdditionalQualifications(applicationDTO.getAdditionalQualifications());
        application.setWorkingType(applicationDTO.getWorkingType());

        approval.setApplication(application);
        approval.setApprovalStatus(ApprovalStatus.PENDING);
        application.setApproval(approval);

        applicationRepo.save(application);
        return  modalMapper.map( modalMapper.map( applicationRepo.save(application),Application.class),ApplicationDTO.class);

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
