package lk.creativelabs.jobseekers.service;

import lk.creativelabs.jobseekers.dto.ClientDTO;
import lk.creativelabs.jobseekers.dto.EmployeeDTO;
import lk.creativelabs.jobseekers.dto.UserCredentialsDTO;

import java.util.ArrayList;

public interface ClientService {

    ClientDTO createNewClient(ClientDTO clientDetails);
    ClientDTO updateClient(ClientDTO clientDetails,String userId) throws Exception;
    boolean deleteClient(String clientId);
    String Login(UserCredentialsDTO loginDetails);
    ArrayList<EmployeeDTO> getAllClients();
    Object getClient(String userId, String role) throws Exception;


    ArrayList<EmployeeDTO> getAllEmployeesByClientUserId(String userId) throws Exception;

    ArrayList<String> getFilteredAllJobTypes(String userId) throws Exception;
}
