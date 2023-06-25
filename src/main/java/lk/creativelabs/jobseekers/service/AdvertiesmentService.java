package lk.creativelabs.jobseekers.service;

import lk.creativelabs.jobseekers.dto.AdvertiesmentDTO;
import lk.creativelabs.jobseekers.dto.ClientDTO;
import lk.creativelabs.jobseekers.dto.EmployeeDTO;
import lk.creativelabs.jobseekers.dto.UserCredentialsDTO;

import java.time.LocalDate;
import java.util.ArrayList;

public interface    AdvertiesmentService {
    AdvertiesmentDTO createNewAdvertiesment(AdvertiesmentDTO advertiesmentDTO,String userId) throws Exception;
    AdvertiesmentDTO updateAdvertiesment(AdvertiesmentDTO advertiesmentDTO,String userId);
    boolean deleteAdvertiesment(String userId);
    ArrayList<AdvertiesmentDTO> getAllAdvertiesmentsByClientId(String userId);
    ArrayList<AdvertiesmentDTO> getAllAdvertiesmentsByEmployeeJobType(String jobType) ;

    void deleteByDate(LocalDate localDate);

    ArrayList<AdvertiesmentDTO> getAllAdvertiesments();
}
