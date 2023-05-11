package lk.creativelabs.jobseekers.service.impl;

import lk.creativelabs.jobseekers.dto.ClientDTO;
import lk.creativelabs.jobseekers.dto.EmployeeDTO;
import lk.creativelabs.jobseekers.dto.UserCredentialsDTO;
import lk.creativelabs.jobseekers.entity.Client;
import lk.creativelabs.jobseekers.entity.Employee;
import lk.creativelabs.jobseekers.entity.UserCredentials;
import lk.creativelabs.jobseekers.entity.enums.ApprovalStatus;
import lk.creativelabs.jobseekers.repo.ClientRepo;
import lk.creativelabs.jobseekers.repo.UserCredentialsRepo;
import lk.creativelabs.jobseekers.service.ClientService;
import lk.creativelabs.jobseekers.util.UserIdGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

   @Autowired
   ClientRepo clientRepository;


    @Autowired
    UserCredentialsRepo authRepo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public ClientDTO createNewClient(ClientDTO clientDetails) {
        try{
            String userId = UserIdGenerator.generateUserId();
            Client client = mapper.map(clientDetails, Client.class);
            client.setUserId(userId);
            clientRepository.save(client);
            authRepo.save(new UserCredentials(clientDetails.getUserName(),passwordEncoder.encode(clientDetails.getPassword()),userId,clientDetails.getRole()));
            return new ClientDTO(clientDetails.getOwner(),clientDetails.getBusinessName(),clientDetails.getBusinessType(),clientDetails.getAddress(),clientDetails.getBusinessRegistrationDocUri(),clientDetails.getBusinessRegistrationNo(),clientDetails.getEmail(),clientDetails.getTel(),clientDetails.getProfileImageUri(),clientDetails.getApprovalStatus());
        }catch (Error error){
            return null;
        }
    }

    @Override
    public boolean updateClient(ClientDTO clientDetails) {
        return false;
    }

    @Override
    public boolean deleteClient(String clientId) {
        return false;
    }

    @Override
    public String Login(UserCredentialsDTO loginDetails) {
        return null;
    }

    @Override
    public ArrayList<EmployeeDTO> getAllClients() {
        return null;
    }

    @Override
    public Object getClient(String userId, String role) throws Exception {


        try{
            String approvalStatus = clientRepository.findApprovalStatusByUserId(userId);
            System.out.println("");
            if(approvalStatus.equals(ApprovalStatus.PENDING.name())){

                   return "This client not Approved ";
            } else if (approvalStatus.equals(ApprovalStatus.REJECTED.name())) {

                   return "This client not Approved ";
            }
            Client client = clientRepository.getClientByUserIdAndRole(userId, role);
            ClientDTO clientDTO =  new ClientDTO(client.getOwner(),client.getBusinessName(),client.getBusinessType(),client.getAddress(),client.getEmail(),client.getTel(),client.getProfileImageUri(),client.getApprovalStatus());
            return clientDTO;
        }catch (Exception exception){
            throw new Exception(exception);
        }

    }
}
