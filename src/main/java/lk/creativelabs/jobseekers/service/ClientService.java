package lk.creativelabs.jobseekers.service;

import lk.creativelabs.jobseekers.dto.ClientDTO;
import lk.creativelabs.jobseekers.dto.EmployeeDTO;

import java.util.ArrayList;

public interface ClientService {

    ClientDTO createNewClient(ClientDTO clientDetails);
    boolean updateClient(ClientDTO clientDetails);
    boolean deleteClient(String clientId);
    String Login(LoginDTO loginDetails);
    ArrayList<EmployeeDTO> getAllClients();
    EmployeeDTO getClient(String clientId);

}
